package com.example.mike.mathtogo2;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Prozent extends AppCompatActivity {

    EditText Prozent,In,Out;
    Button Submit;
    TextView HitMiss;
    double prozent , input , output,wins,rounds,hm;
    int rng;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prozent);
        Prozent = (EditText) findViewById(R.id.editProzent);
        In = (EditText) findViewById(R.id.editIn);
        Out = (EditText) findViewById(R.id.editOut);
        HitMiss = (TextView) findViewById(R.id.textHitMissProzent) ;
        Submit = (Button) findViewById(R.id.button3);
    CreateTaskProzent();
    }

    public void CreateTaskProzent(){

        prozent = (double)((int)(Math.random()*(100-0)+0));
        while (!(prozent%5 == 0)){
            prozent++;
        }
        input  = (double)((int)(Math.random()*(200-0)+0));
        output = (double)((int)(Math.random()*(200-0)+0));
        rng = ((int)(Math.random()*(99-0)+0));

       if(rng<=33){
            Prozent.setText(""+prozent);
            In.setText(""+input);
        }else if(rng>=66){
            Prozent.setText(""+prozent);
            Out.setText(""+output);

        }else {
            In.setText(""+input);
            Out.setText(""+output);
        }


    }


    public void SubmitProzent(View v){

        input = Double.parseDouble(In.getText().toString());
        output = Double.parseDouble(Out.getText().toString());
        prozent = Double.parseDouble(Prozent.getText().toString());
        prozent = prozent/100;
        Prozent.setText("");
        In.setText("");
        Out.setText("");
        rounds++;



        if(input*prozent == output){
            wins++;
            Submit.setBackgroundColor(0xFF00B212);

        }else{
            Submit.setBackgroundColor(0xFFfb0c0c);
        }
        hm = ((double)(wins/rounds)*10000)/100;
        String HMiss = "Hit/Miss = "+hm;
        if(HMiss.length()>=16){
            HMiss =  HMiss.substring(0,15);
        }

        HitMiss.setText(HMiss);
        CreateTaskProzent();


    }








}
