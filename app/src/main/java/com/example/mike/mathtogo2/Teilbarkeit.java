package com.example.mike.mathtogo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Teilbarkeit extends AppCompatActivity {

    double HM;
    TextView HitMiss;
    TextView Vorgabe;
    double rounds;
    double wins;
    CheckBox teil2,teil3,teil4,teil5,teil8,teil9;
    Button Submit;
    double vorgabe;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teilbarkeit);
        HitMiss = (TextView) findViewById(R.id.textHitMissTeil);
        Submit = (Button) findViewById(R.id.button2);
        teil2 = (CheckBox) findViewById(R.id.checkBox);
        teil3 = (CheckBox) findViewById(R.id.checkBox2);
        teil4 = (CheckBox) findViewById(R.id.checkBox3);
        teil5 = (CheckBox) findViewById(R.id.checkBox4);
        teil8 = (CheckBox) findViewById(R.id.checkBox5);
        teil9 = (CheckBox) findViewById(R.id.checkBox6);
        Vorgabe = (TextView) findViewById(R.id.textView6);

        creatTaskTeil();

    }


    public void creatTaskTeil(){

        vorgabe = (double)((int)(Math.random()*(99999-0)+0));
        Vorgabe.setText(""+vorgabe);




    }

    public void SubmitTeil(View v){

        rounds++;
        if((vorgabe%2==0) == teil2.isChecked()&&(vorgabe%3==0) == teil3.isChecked()&&(vorgabe%4==0) == teil4.isChecked()&&(vorgabe%5==0) == teil5.isChecked()&&(vorgabe%8==0) == teil8.isChecked()&&(vorgabe%9==0) == teil9.isChecked() ){
            wins++;
            Submit.setBackgroundColor(0xFF00B212);

        }else{
            Submit.setBackgroundColor(0xFFfb0c0c);
        }


        teil2.setSelected(false);
        teil3.setSelected(false);
        teil4.setSelected(false);
        teil5.setSelected(false);
        teil8.setSelected(false);
        teil9.setSelected(false);





        HM = ((double)(wins/rounds)*10000)/100;
        String HMiss = "Hit/Miss = "+HM;
        if(HMiss.length()>=16){
            HMiss =  HMiss.substring(0,15);
        }
        HitMiss.setText(HMiss);

        creatTaskTeil();





    }


}
