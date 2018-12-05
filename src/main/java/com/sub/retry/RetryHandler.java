package com.sub.retry;

public interface RetryHandler<T> {

    int handle(T param, int retryCount) throws RetryException;

}
