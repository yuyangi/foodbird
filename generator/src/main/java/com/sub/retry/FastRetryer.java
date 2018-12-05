package com.sub.retry;

import java.util.Collection;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class FastRetryer implements Retryer {

    FastRetryer() {
    }

    @Override
    public void addRetry(RetryObject<?> retryObject) {

    }

    @Override
    public void removeRetry(RetryObject<?> retryObject) {

    }

    @Override
    public int maxRetryTime() {
        return 0;
    }

    @Override
    public Collection<RetryObject> retryList() {
        return null;
    }

    @Override
    public void retry(RetryObject retryObject) {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
