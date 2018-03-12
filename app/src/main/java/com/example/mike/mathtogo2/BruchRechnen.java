package com.example.mike.mathtogo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BruchRechnen extends AppCompatActivity {


    TextView BLO,BLU,BRO,BRU,OP,HM;
    Button Submit;
    int wins,rounds;
    double result,hm,blo,blu,bro,bru,inputUP,InputDOWN;
    EditText InputU,InputD;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bruch_rechnen);
        BLO = (TextView) findViewById(R.id.BLO);
        BLU=(TextView) findViewById(R.id.BLU);
        BRO=(TextView) findViewById(R.id.BRO);
        BRU=(TextView) findViewById(R.id.BRU);
        OP=(TextView) findViewById(R.id.Operator);
        HM=(TextView) findViewById(R.id.HitMiss);
        Submit = (Button) findViewById(R.id.SubmitBruch);
        InputU = (EditText) findViewById(R.id.InputBO);
        InputD = (EditText) findViewById(R.id.InputBU);


        CreateTaskBruch();




    }


    public void CreateTaskBruch(){
        int operatorrng;


        blo = (int)RandomNumber(100,0);
        blu = (int)RandomNumber(100,1);
        bro = (int)RandomNumber(100,0);
        bru = (int)RandomNumber(100,1);
        operatorrng = (int)RandomNumber(100,0);

        BLO.setText(""+(int)blo);
        BLU.setText(""+(int)blu);
        BRO.setText(""+(int)bro);
        BRU.setText(""+(int)bru);



        if(operatorrng <= 25){
            result = (blo/blu)+(bro/bru);
            OP.setText(" + ");
        }else if(operatorrng >25 && operatorrng <=50){
            result = (blo/blu)-(bro/bru);
            OP.setText(" - ");
        }else if(operatorrng >50 && operatorrng <=75){
            result = (blo/blu)*(bro/bru);
            OP.setText(" * ");
        }else{
            result = (blo/blu)/(bro/bru);
            OP.setText(" / ");
        }

        result = (double)((int)(result*100))/100;


    }

    public double RandomNumber(int max,int min){
       int maxa = max;
        int minb = min;
        double rng;

      rng =  (double)((int)(Math.random()*(maxa-minb)+minb));

        return rng;
    }

    public void SubmitBruch(View v){

        double inputresult;


        try {


            InputDOWN = Integer.parseInt(InputD.getText().toString());
        } catch (NumberFormatException e) {
            System.out.print(e);
            InputDOWN = -1.0;
        }

        try {


            inputUP = Integer.parseInt(InputU.getText().toString());
        } catch (NumberFormatException e) {
            System.out.print(e);
            inputUP  = -1.0;
        }


try {

    inputresult = ((double) (((int) ((inputUP / InputDOWN) * 100))) / 100);

}catch (NumberFormatException e){
            inputresult = -1.0;
}




        rounds++;
        InputU.setText("");
        InputD.setText("");



        if(inputresult == result){
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

        HM.setText(HMiss);
        CreateTaskBruch();





    }



}
