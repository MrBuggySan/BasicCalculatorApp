package com.lemune.calculator_ensf409_lab10;

/**
 * Created by Beast Mode on 4/8/2016.
 */
public class Queue<T> {

    private SLL<T> a;


    public Queue(){
        a=new SLL<T>();
    }

    /**
     *
     */



    public T dequeue()throws WrongInputException {
        if(a.isEmpty()){
            //I must impliment an exception if this ever occurs
            //System.out.println("The queue is empty, we cannot dequeue anymore!");
            throw new WrongInputException();

        }
        else return a.deleteFromHead();
    }

    public void queue(T element){
        a.addToTail(element);
    }

    public boolean isEmpty(){
        if(a.isEmpty())
            return true;
        return false;
    }

    public T peek() throws WrongInputException{
        if(a.isEmpty()){
            //I must impliment an exception if this ever occurs
            //System.out.println("The queue is empty, we cannot peek at anything!");
            throw new WrongInputException();

        }
        return a.headcontent();
    }

}