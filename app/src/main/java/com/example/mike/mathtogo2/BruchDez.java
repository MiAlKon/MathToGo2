package com.example.mike.mathtogo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BruchDez extends AppCompatActivity {

    int valueBruchOben;
    int valueBruchUnten;
    double valueDez;
    Button SendResult;
    EditText Boben;
    EditText Bunten;
    EditText Dez;
    double result;
    double HM;
    TextView HitMiss;
    double rounds;
    double wins;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bruch_dez);
        SendResult=(Button) findViewById(R.id.buttonSend);
         Boben=(EditText) findViewById(R.id.editTextBruchOben);
        Bunten=(EditText) findViewById(R.id.editBruchUnten);
         Dez=(EditText) findViewById(R.id.editDez);
         HitMiss = (TextView) findViewById(R.id.textViewHM);
         CreateTask();
    }

    public void CreateTask(){

        Boben.setText("");
        Bunten.setText("");
        Dez.setText("");

        int rng = (int)(Math.random()*(10-0)+0);
        valueBruchOben = (int)(Math.random()*(200-0)+0);
        valueBruchUnten = (int)(Math.random()*(20-0)+0);
        valueDez = Math.random()*((200-0)+0);
        result = (double)valueBruchOben/(double)valueBruchUnten;
        result = (double)((int)(result*100))/100;
        valueDez = (double)((int)(valueDez*100))/100;


        if(rng > 5){

            Boben.setText(""+valueBruchOben);
            Bunten.setText(""+valueBruchUnten);



        }else {

            Dez.setText(""+valueDez);
        }





    }

    public void ResultBruchDez(View v){
        double InputDez = Double.parseDouble(Dez.getText().toString().replace(',','.'));
        InputDez = (double)((int)(InputDez*100))/100;
        double InputBO;
        double InputBU;





        try {
        InputBO = Double.parseDouble(Boben.getText().toString());
        InputBU = Double.parseDouble(Bunten.getText().toString());


        } catch (NumberFormatException e) {
            System.out.print(e);
            InputBO = -1.0;
            InputBU = -1.0;
        }








        double InputBruch = (double)((int)(InputBO/InputBU*100))/100;
        rounds++;

        if(InputDez == result){
            wins++;
            SendResult.setBackgroundColor(0xFF00B212);
        }else if(InputBruch == valueDez){
            wins++;
            SendResult.setBackgroundColor(0xFF00B212);
        }else{
            SendResult.setBackgroundColor(0xFFfb0c0c);
        }
        HM = ((double)(wins/rounds)*10000)/100;
        String HMiss = "Hit/Miss = "+HM;
        if(HMiss.length()>=16){
            HMiss =  HMiss.substring(0,15);
        }

        HitMiss.setText(HMiss);


        CreateTask();
    }
}








