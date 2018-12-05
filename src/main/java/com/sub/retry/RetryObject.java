package com.sub.retry;

import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class RetryObject<T> implements Delayed {

    private T param;

    private long delayTime;

    private int retryCount = 0;

    private long targetTime;

    private RetryHandler<T> handler;

    public RetryObject(T param) {
        this.param = param;
    }

    public RetryObject(T param, long delayTime) {
        this.param = param;
        this.delayTime = delayTime;
        this.targetTime = System.currentTimeMillis() + delayTime;
    }

    public RetryObject(T param, long delayTime, int retryCount) {
        this.param = param;
        this.delayTime = delayTime;
        this.retryCount = retryCount;
    }

    public RetryObject(T param, long delayTime, RetryHandler<T> handler) {
        this.param = param;
        this.delayTime = delayTime;
        this.handler = handler;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(targetTime - System.currentTimeMillis(),  TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) {
            return 1;
        }
        if (o instanceof RetryObject) {
            RetryObject od = (RetryObject) o;
            return (int) (delayTime - od.delayTime);
        }
        return -1;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public RetryHandler<T> getHandler() {
        return handler;
    }

    public void setHandler(RetryHandler<T> handler) {
        this.handler = handler;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetryObject that = (RetryObject) o;
        return Objects.equals(param, that.param) && Objects.equals(handler.getClass(), that.handler.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(param, delayTime, handler);
    }
}
