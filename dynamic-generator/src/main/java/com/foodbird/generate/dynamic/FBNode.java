package com.foodbird.generate.dynamic;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/29
 */
public class FBNode {

    public FBNode(FBIAction current) {
        this.current = current;
    }

    private FBIAction current;

    private FBNode next;

    public FBIAction getCurrent() {
        return current;
    }

    public void setCurrent(FBIAction current) {
        this.current = current;
    }

    public FBNode getNext() {
        return next;
    }

    public void setNext(FBNode next) {
        this.next = next;
    }

}
