package com.foodbird.generate.dynamic;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public class FBNode {

    public FBNode(FBIAction action) {
        this.action = action;
    }

    private FBIAction action;

    private FBNode next;

    public FBIAction getAction() {
        return action;
    }

    public void setCurrent(FBIAction action) {
        this.action = action;
    }

    public FBNode getNext() {
        return next;
    }

    public void setNext(FBNode next) {
        this.next = next;
    }

}
