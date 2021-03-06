package com.foodbird.generate.java.exception;

/**
 * Created by yy111026 on 2017/2/10.
 */
public class UnsupportedParameterException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedParameterException() {
        super();
    }

    public UnsupportedParameterException(String message) {
        super(message);
    }

    public UnsupportedParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedParameterException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
