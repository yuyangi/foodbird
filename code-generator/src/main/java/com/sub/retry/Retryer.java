package com.sub.retry;

import java.util.Collection;

public interface Retryer extends Runnable {

    int MAX_RETRY_COUNT = 3;

    long RETRY_DELAYED_TIME = 5000L;

    void addRetry(RetryObject<?> retryObject);

    void removeRetry(RetryObject<?> retryObject);

    int maxRetryTime();

    Collection<RetryObject> retryList();

    void retry(RetryObject retryObject);

    void stop();

}