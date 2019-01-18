package com.foodbird.generate.dynamic;

import java.util.Iterator;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2018/12/28
 */
public class FBSeries implements Iterator {

    private String service;

    private FBNode first;

    private FBNode current;

    public FBSeries(String service) {
        this.service = service;
    }

    public FBNode find(String id) {
        return find(first, id);
    }

    public FBNode find(FBNode start, String id) {
        if (start == null) {
            return null;
        }
        FBNode node = start;
        while (node != null) {
            if (node.getAction().id().equals(id)) {
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
        boolean added = false;
        while (current != null) {
            if (current.getAction().id().equals(id)) {
                if (pre != null) {
                    pre.setNext(node);
                    node.setNext(current);
                } else {
                    node.setNext(current);
                    current = node;
                }
                added = true;
            } else {
                pre = current;
                current = current.getNext();
            }
        }
        if (!added) {
            pre.setNext(node);
        }
    }

    public void addAfter(String id, FBNode node) {
        if (first == null) {
            return;
        }
        FBNode current = first;
        FBNode pre = null;
        boolean added = false;
        while (current != null) {
            if (current.getAction().id().equals(id)) {
                FBNode next = current.getNext();
                current.setNext(node);
                if (next != null) {
                    node.setNext(next);
                }
                added = true;
            } else {
                pre = current;
                current = current.getNext();
            }
        }
        if (!added) {
            pre.setNext(node);
        }
    }

    public void addLast(FBNode node) {
        if (first == null) {
            first = node;
            return;
        }
        FBNode current = first;
        FBNode pre = null;
        while (current != null) {
            pre = current;
            current = current.getNext();
        }
        pre.setNext(node);
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    @Override
    public Object next() {
        if (current == null) {
            current = first;
        } else {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void remove() {
        if (current == null) {
            current = first;
        }
        FBNode temp = first;
        FBNode pre = null;
        while (temp != null) {
            if (temp.getAction().id().equals(current.getAction().id())) {
                break;
            }
            pre = temp;
            temp = temp.getNext();
        }
        if (pre != null) {
            current = current.getNext();
            pre.setNext(current);
        } else {
            first = current.getNext();
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
