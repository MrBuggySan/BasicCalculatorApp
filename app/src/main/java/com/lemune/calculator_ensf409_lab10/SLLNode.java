package com.lemune.calculator_ensf409_lab10;

/**
 * Created by Beast Mode on 4/8/2016.
 */
public class SLLNode<T>{
    public T info;
    public SLLNode<T> next;

    public SLLNode() {
        this(null,null);
    }
    public SLLNode(T el) {
        this(el,null);
    }
    public SLLNode(T el, SLLNode<T> ptr) {
        info = el; next = ptr;
    }


}
