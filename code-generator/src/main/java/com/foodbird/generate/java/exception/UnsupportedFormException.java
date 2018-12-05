package com.foodbird.generate.java.exception;

/**
 * Created by yy111026 on 2017/2/10.
 */
public class UnsupportedFormException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedFormException() {
        super("Unsupported form of code strategy");
    }

    public UnsupportedFormException(String message) {
        super(message);
    }

    public UnsupportedFormException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFormException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedFormException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
