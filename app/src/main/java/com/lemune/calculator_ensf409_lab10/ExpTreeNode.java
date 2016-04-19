package com.lemune.calculator_ensf409_lab10;

/**
 * Created by Beast Mode on 4/8/2016.
 */
public class ExpTreeNode {
    String el ;
    ExpTreeNode left , right ;

    ExpTreeNode ( String e ) {
        this (e , null , null );
    }

    ExpTreeNode ( String e , ExpTreeNode l ,ExpTreeNode r ){
        el = new String ( e );
        left = l;
        right = r;
    }
}
