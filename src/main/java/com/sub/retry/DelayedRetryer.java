package com.sub.retry;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class DelayedRetryer implements Retryer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DelayedRetryer.class);

    private DelayQueue<RetryObject> retryFailedQueue;

    private Map<Class, RetryHandler> typeHandlers;

    private boolean retry = true;

    DelayedRetryer() {
        typeHandlers = Maps.newConcurrentMap();
        retryFailedQueue = new DelayQueue<>();
    }

    @Override
    public int maxRetryTime() {
        return MAX_RETRY_COUNT;
    }

    @Override
    public Collection<RetryObject> retryList() {
        return retryFailedQueue;
    }

    @Override
    public void addRetry(RetryObject recover) {
        if (retryFailedQueue.contains(recover)) {
            return;
        }
        retryFailedQueue.offer(recover, 5, TimeUnit.SECONDS);
    }

    @Override
    public void removeRetry(RetryObject recover) {
        retryFailedQueue.remove(recover);
    }

    @Override
    public void run() {
        while (retry) {
            try {
                RetryObject retry = retryFailedQueue.take();
                retry(retry);
            } catch (InterruptedException e) {
                LOGGER.error("Take from recover queue was interrupted, please try again later.", e);
            }
        }
    }

    public void stop() {
        retry = false;
    }

    public void retry(RetryObject recover) {
        try {
            boolean shouldContinue = false;
            Stopwatch sw = Stopwatch.createStarted();
            LOGGER.warn("------------Retry " + recover.getRetryCount() + " time begin!------------");
            if (recover == null) {
                shouldContinue = true;
            }

            Object param = recover.getParam();
            RetryHandler handler = recover.getHandler();
            // 暂时不处理空参数的情况，空参数需要自己做handler
            if (handler == null && param != null) {
                handler = typeHandlers.get(param.getClass());
                if (handler == null) {
                    LOGGER.warn("No handler for " + param.getClass() + ". Recover will be skipped.");
                    shouldContinue = true;
                }
            }
            // 无法处理的参数
            if (shouldContinue) {
                return;
            }

            int status = handler.handle(param, recover.getRetryCount());
            switch (status) {
                case RetryStatus.RECOVER_SUCCESS:
                    break;
                case RetryStatus.RECOVER_FAILED:
                    LOGGER.warn("Recover failed:" + param);
                    break;
                case RetryStatus.RECOVER_FAILED_RETRY:
                    long delayTime = recover.getDelayTime();
                    int retryCount = recover.getRetryCount();
                    if (retryCount <= MAX_RETRY_COUNT) {
                        recover.setDelayTime(delayTime + RETRY_DELAYED_TIME);
                        recover.setRetryCount(retryCount + 1);
                        this.addRetry(recover);
                    } else {
                        LOGGER.warn("Retry times are exceeded the max retry count. Parameter is " + Objects.requireNonNull(param).toString());
                    }
                    break;
                default:
                    break;
            }

            LOGGER.warn("------------Retry " + recover.getRetryCount() + " time end! Cost " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms.------------");
        } catch (RetryException e) {
            if (e.isNeedRetry()) {
                LOGGER.warn("Recover handler had an exception:" + e.getMessage() + ". Need to by recovered.", e);
                retryFailedQueue.offer(new RetryObject(e.getParam(), RETRY_DELAYED_TIME, e.getRetryCount()+1));
            } else {
                LOGGER.error("Recover handler had an exception:" + e.getMessage(), e);
            }
        }
    }
}
