package com.sub.retry;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class RetryerFactory {

    public static final int DELAYED_RETRYER = 1;

    public static final int FAST_RETRYER = 2;

    private int retryerType = 0;

    private static Map<Integer, Retryer> retryers;

    static {
        retryers = Maps.newHashMap();
        retryers.put(DELAYED_RETRYER, Retryers.newDelayedRetryer());
        retryers.put(FAST_RETRYER, Retryers.newFastRetryer());
    }

    private RetryerFactory(int retryerType) {
        this.retryerType = retryerType;
    }

    public static Retryer create(int type) {
        return new RetryerFactory(type).start();
    }

    private Retryer start() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Retryer retryer = retryers.get(retryerType);
        if (retryer == null) {
            throw new IllegalArgumentException("No retry type found:" + retryerType);
        }
        executorService.submit(retryer);
        return retryer;
    }

}
