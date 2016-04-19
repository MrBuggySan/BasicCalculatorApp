package com.lemune.calculator_ensf409_lab10;

/**
 * Created by Beast Mode on 4/8/2016.
 */

public class Stack<T> {
    private SLL <T > list = new SLL <T >();

    public boolean isEmpty(){
        if( list.isEmpty())
            return true;
        else return false;
    }

    public T pop () {
        if ( isEmpty ())
            throw new java.util.EmptyStackException ();
        return list.deleteFromTail();
    }

    public void push (T el ) {
        list.addToTail ( el );
    }
}

