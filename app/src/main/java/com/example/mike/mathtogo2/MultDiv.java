package com.example.mike.mathtogo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MultDiv extends AppCompatActivity {



    double value1;
    int value2;
    double result;
    TextView Textfieldvalue1;
    TextView Textfieldvalue2;
    TextView Textfieldoperator;
    TextView TextfieldHitMiss;
    Button SendResult;
    EditText Result;
    double inputresult;
    double HM;
    double numberofRuns;
    double wins;
    String valueStr1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_div);
        Textfieldvalue1 = (TextView)findViewById(R.id.textView);
        Textfieldvalue2 = (TextView)findViewById(R.id.textView3);
        Textfieldoperator = (TextView)findViewById(R.id.textView2);
        TextfieldHitMiss = (TextView)findViewById(R.id.textViewHM);
        Result = (EditText)findViewById(R.id.editText);
        SendResult = (Button)findViewById(R.id.Sendbutton);
        CreateTask();
    }


    public void CreateTask(){


        value1 = (Math.random()*(2000-0)+0)/10;
        valueStr1 = Double.toString(value1);
        value1 = Double.parseDouble(valueStr1.substring(0,4));




        value2 = (int)Math.round(Math.random()*(30-0)+0);
        int operator = (int)Math.round(Math.random());

        if(operator==1){
            Textfieldoperator.setText("*");
            result = value1 * value2;
        }else{
            Textfieldoperator.setText("/");
            result = value1 / value2;
        }

        valueStr1 = Double.toString(result);
        if(valueStr1.length()>6){
            valueStr1= valueStr1.substring(0,6);
            result = Double.parseDouble(valueStr1);
            if(result<10){
                valueStr1= valueStr1.substring(0,4);
                result = Double.parseDouble(valueStr1);
            }

        }




        Textfieldvalue1.setText(""+value1);
        Textfieldvalue2.setText(""+value2);

    }

    public void ResultMultDiv(View v)
    {

        String Input= Result.getText().toString();
        if(Input == null){
            Input= "0";
        }
        Input = Input.replace(',','.');



        if(Input.length()>5) {
           Input = Input.substring(0, valueStr1.length());
        }
        inputresult = Double.parseDouble(Input);


        numberofRuns++;

        if(inputresult == result){
        wins++;
        SendResult.setBackgroundColor(0xFF00B212);

            //win
        }else{
            SendResult.setBackgroundColor(0xFFfb0c0c);//lose
        }



        HM = ((double)(wins/numberofRuns)*10000)/100;
        String HMiss = "Hit/Miss = "+HM;
        if(HMiss.length()>=16){
          HMiss =  HMiss.substring(0,15);
        }







        TextfieldHitMiss.setText(HMiss);
        SendResult.setText("= "+result);
        Result.setText("");

        CreateTask();







    }

}
