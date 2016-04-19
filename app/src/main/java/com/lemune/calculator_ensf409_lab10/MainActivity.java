package com.lemune.calculator_ensf409_lab10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onNumClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();



        TextView myTextView = (TextView) findViewById(R.id.display);
        String current_text=myTextView.getText().toString();
        current_text+=bText;

        myTextView.setText(current_text);
    }

    public void onOpClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();



        TextView myTextView = (TextView) findViewById(R.id.display);
        String current_text=myTextView.getText().toString();
        switch(bText){
            case "(": current_text+=bText+" ";
                    break;
            case ")":current_text+=" "+bText;
                    break;
            default :  current_text+=" "+bText+" ";
                break;
        }


        myTextView.setText(current_text);
    }




    public void onCancelClick(View v){
        TextView myTextView = (TextView) findViewById(R.id.display);
        myTextView.setText("");
    }


    public void onEqualClick(View v){
        TextView myTextView = (TextView) findViewById(R.id.display);
        String equation_text=myTextView.getText().toString();




        ExpParser parser=new ExpParser();
        Display_expr_tree a= new Display_expr_tree();
        try{
            //contains the equation that we have to do an operation on
            ExpTreeNode result=parser.expression(parser.create_queue(equation_text));

            a.calculate(result);
            myTextView.setText(a.getexpression());

        }catch(WrongInputException e){
            System.out.println(e.getMessage());
            myTextView.setText(e.getMessage());
         }


    }

}
