package com.lemune.calculator_ensf409_lab10;


/**
 * Created by Beast Mode on 4/8/2016.
 */
public class ExpParser {

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;

        //takes care of the negative number
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }




    public boolean isexpression(String a){
        if (isterm(a)|| a.equals("+")|| a.equals("-")){
            return true;
        }
        else return false;
    }

    public boolean isterm(String a){
        if (isfactor(a) || a.equals("*") || a.equals("/")){
            return true;
        }
        else return false;
    }

    public boolean isDouble(String str){
        try {
            //Double.parseDouble(str);
            System.out.println("I got here "+Double.parseDouble(str));
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isfactor(String a){
        if (a.equals("(") || isDouble(a)){
            return true;
        }
        else return false;

    }

    public static boolean isoperator(String a){
        if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/"))
            return true;
        else return false;
    }


    public ExpTreeNode term(Queue<String> expression_queue)throws WrongInputException {
        ExpTreeNode a=factor(expression_queue);
        ExpTreeNode b;
        if(!expression_queue.isEmpty()){
            if (isoperator(expression_queue.peek())){
                while(expression_queue.peek().equals("*") || expression_queue.peek().equals("/")){
                    String op=expression_queue.dequeue();
                    b=factor(expression_queue);
                    a=new ExpTreeNode(op,a,b);
                    if(expression_queue.isEmpty())
                        break;

                }
            }
            else{
                //System.out.println("There cannot be a number  or bracket here...");
                throw new WrongInputException();
            }
        }

        return a;

    }

    public ExpTreeNode factor(Queue<String> expression_queue)throws WrongInputException {
        String possible_factor=expression_queue.dequeue();

        if(isfactor(possible_factor)){
            ExpTreeNode a;
            if(isDouble(possible_factor)){

                a=new ExpTreeNode(possible_factor);
            }
            else{//We know that this is a bracket
                int num_bracket=1;

                String to_test="";
                Queue<String> new_expression_queue=new Queue<String>();
                //We need to delete the outer most brackets
                while(num_bracket!=0 && !expression_queue.isEmpty()){
                    to_test=expression_queue.dequeue();
                    if(to_test.equals("("))
                        num_bracket++;
                    if(to_test.equals(")"))
                        num_bracket--;
                    if(num_bracket==0) break;

                    if(expression_queue.isEmpty()){
                        //There is no outer bracket corresponding to the first
                        //Let the user know of this error
                        //System.out.println("The queue is empty, there are not enough brackets! Exiting the program now");
                        throw new WrongInputException();
                        //System.exit(1);
                    }
                    new_expression_queue.queue(to_test);

                }
                a=expression(new_expression_queue);
            }
            return a;
        }
        else {
            throw new WrongInputException();

        }
    }
    public ExpTreeNode expression(Queue<String> expression_queue)throws WrongInputException {

        ExpTreeNode a=term(expression_queue);
        ExpTreeNode b;

        if(!expression_queue.isEmpty()){
            if (isoperator(expression_queue.peek())){
                while(expression_queue.peek().equals("+") || expression_queue.peek().equals("-")){
                    String op=expression_queue.dequeue();
                    b=term(expression_queue);
                    a=new ExpTreeNode(op,a,b);
                    if(expression_queue.isEmpty())
                        break;

                }
            }
            else{
                throw new WrongInputException();
            }

        }

        return a;


    }

    public String[] space_remover(String a){
        String[] b=a.split(" ");
        return b;
    }

    /**
     * Create the stack from the array of Strings
     * @param a
     */
    public Queue<String> create_queue(String a){
        String[] b=this.space_remover(a);
        Queue<String> expression_queue= new Queue<String>();
        for(int i=0; i< b.length ; i++){
           // System.out.println(b[i]);
            expression_queue.queue(b[i]);
        }
        return expression_queue;

    }


}
