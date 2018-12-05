package com.sub.retry;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class RetryException extends Exception {

    private boolean needRetry;

    private Object param;

    private int retryCount;

    public RetryException(String message) {
        super(message);
    }

    public RetryException(String message, boolean needRetry, Object param) {
        this.needRetry = needRetry;
        this.param = param;
    }

    public RetryException(String message, boolean needRetry) {
        super(message);
        this.needRetry = needRetry;
    }

    public boolean isNeedRetry() {
        return needRetry;
    }

    public void setNeedRetry(boolean needRetry) {
        this.needRetry = needRetry;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
