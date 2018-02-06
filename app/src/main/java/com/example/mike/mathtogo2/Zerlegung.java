package com.example.mike.mathtogo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Zerlegung extends AppCompatActivity {

    double Dez,zehnmin1,zehnmin2;
    int zehn3,zehn2,zehn1,zehn0;
    EditText zehn3Text,zehn2Text,zehn1Text,zehn0Text,zehnM1Text,zehnM2Text;
    TextView DezText,HitMiss;
    int wins,rounds;
    Double HM;
    Button Submit;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zerlegung);
        zehn3Text = (EditText) findViewById(R.id.editText103);
        zehn2Text = (EditText) findViewById(R.id.editText102);
        zehn1Text = (EditText) findViewById(R.id.editText101);
        zehn0Text = (EditText) findViewById(R.id.editText100);
        zehnM1Text = (EditText) findViewById(R.id.editText10M1);
        zehnM2Text = (EditText) findViewById(R.id.editText10M2);
        DezText = (TextView) findViewById(R.id.textView7);
        Submit = (Button) findViewById(R.id.button);
        HitMiss = (TextView) findViewById(R.id.textViewHM);
        CreateTask();

    }

    public void CreateTask(){


        Dez = (double)((int)(Math.random()*(200000-0)+0))/100;
        DezText.setText(""+Dez);


    }

    public void ResultZerlegung (View v){

        double result;

        rounds++;
        zehn3 = Integer.parseInt(zehn3Text.getText().toString()) * 1000;
        zehn2 = Integer.parseInt(zehn2Text.getText().toString()) * 100;
        zehn1 = Integer.parseInt(zehn1Text.getText().toString()) * 10;
        zehn0 = Integer.parseInt(zehn0Text.getText().toString()) * 1;
        zehnmin1 = Double.parseDouble(zehnM1Text.getText().toString()) * 0.1;
        zehnmin2 = Double.parseDouble(zehnM2Text.getText().toString()) * 0.01;

        result = zehn3+zehn2+zehn1+zehn0+zehnmin1+zehnmin2;



        if(Dez == result){
            wins++;
            Submit.setBackgroundColor(0xFF00B212);

        }else{
            Submit.setBackgroundColor(0xFFfb0c0c);
        }
        HM = ((double)(wins/rounds)*10000)/100;
        String HMiss = "Hit/Miss = "+HM;
        if(HMiss.length()>=16){
            HMiss =  HMiss.substring(0,15);
        }
        HitMiss.setText(HMiss);

        zehn3Text.setText("");
        zehn2Text.setText("");
        zehn1Text.setText("");
        zehn0Text.setText("");
        zehnM1Text.setText("");
        zehnM2Text.setText("");


        CreateTask();


    }



}
