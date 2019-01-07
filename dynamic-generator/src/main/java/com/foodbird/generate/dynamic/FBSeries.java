package com.foodbird.generate.dynamic;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBSeries {

    private String service;

    private FBNode first;

    public FBSeries(String service) {
        this.service = service;
    }

    public FBNode find(String id) {
        if (first == null) {
            return null;
        }
        FBNode node = first;
        while (node != null) {
            if (node.getCurrent().id().equals(id)) {
                return node;
            } else {
                node = node.getNext();
            }
        }
        return null;
    }

    public void addBefore(String id, FBNode node) {
        if (first == null) {
            return;
        }
        FBNode current = first;
        FBNode pre = null;
        while (current != null) {
            if (current.getCurrent().id().equals(id)) {
                if (pre != null) {
                    pre.setNext(node);
                    node.setNext(current);
                } else {
                    node.setNext(current);
                    current = node;
                }
            } else {
                pre = current;
                current = current.getNext();
            }
        }
    }

    public void addAfter(String id, FBNode node) {
        if (first == null) {
            return;
        }
        FBNode current = first;
        while (current != null) {
            if (current.getCurrent().id().equals(id)) {
                FBNode next = current.getNext();
                current.setNext(node);
                if (next != null) {
                    node.setNext(next);
                }
            } else {
                current = current.getNext();
            }
        }
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public FBNode getFirst() {
        return first;
    }

    public void setFirst(FBNode first) {
        this.first = first;
    }
}
