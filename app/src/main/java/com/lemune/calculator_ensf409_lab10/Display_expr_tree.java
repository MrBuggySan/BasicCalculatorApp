package com.lemune.calculator_ensf409_lab10;

/**
 * Created by Beast Mode on 4/8/2016.
 */
public class Display_expr_tree {
    //Will contain the result
    private String expression="";


    public void visit(String p){
        expression+=p+" ";

    }

    public void reset(){
        this.expression="";
    }

    public void calculate(ExpTreeNode p){
        expression="";
        //convert the expression to a postorder expression
        postorder(p);
        String[] expression_array=expression.split(" ");
        Stack<String> expression_stack=new Stack<String>();
        for(int i=0; i<expression_array.length ; i++){
            if(!ExpParser.isoperator(expression_array[i])){
                //a number
                expression_stack.push(expression_array[i]);
            }
            else{
                //an operator
//                int result=0;
//                int b=Integer.parseInt(expression_stack.pop());
//                int a=Integer.parseInt(expression_stack.pop());

                double result=0;
                double b=Double.parseDouble(expression_stack.pop());
                double a=Double.parseDouble(expression_stack.pop());

                switch(expression_array[i]){
                    case "+": result=a+b;
                        break;
                    case "-": result=a-b;
                        break;
                    case "*": result=a*b;
                        break;
                    case "/": result=a/b;
                        break;
                }
                expression_stack.push(Double.toString(result));

            }
        }
        expression=expression_stack.pop();

    }


    void postorder( ExpTreeNode p) {

        if (p != null ) {
            postorder ( p. left );
            postorder ( p. right );
            visit (p.el );
        }
    }

    public	String getexpression(){
        return this.expression;
    }


}
