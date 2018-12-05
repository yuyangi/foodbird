package com.sub.retry;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class RetryStatus {

    public static final int RECOVER_SUCCESS = 0;

    public static final int RECOVER_FAILED = 1;

    public static final int RECOVER_FAILED_RETRY = 2;

    public static final int RETRY_FAILED = 3;

    public static final int RETRY_COUNT_EXCEEDED = 4;

}
