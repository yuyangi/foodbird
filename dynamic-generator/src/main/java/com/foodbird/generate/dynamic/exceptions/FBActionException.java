package com.foodbird.generate.dynamic.exceptions;

import com.foodbird.generate.dynamic.FBActionContext;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/9
 */
public class FBActionException extends Exception {

    private FBActionContext context;

    public FBActionException() {
    }

    public FBActionException(String message) {
        super(message);
    }

    public FBActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FBActionException(Throwable cause) {
        super(cause);
    }

    public FBActionContext getContext() {
        return context;
    }

    public void setContext(FBActionContext context) {
        this.context = context;
    }
}
