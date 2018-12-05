package com.sub.retry;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/8/6
 */
public class Retryers {

    public static Retryer newDelayedRetryer() {
        return new DelayedRetryer();
    }

    public static Retryer newFastRetryer() {
        return new FastRetryer();
    }

}
