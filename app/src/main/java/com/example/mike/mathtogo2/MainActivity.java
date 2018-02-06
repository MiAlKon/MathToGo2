package com.example.mike.mathtogo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonMD(View v){
        Intent intent = new Intent(this, MultDiv.class);
        startActivity(intent);


    }

    public void buttonBC(View v){
        Intent intent = new Intent(this, BruchDez.class);
        startActivity(intent);


    }


    public void buttonZer(View v){
        Intent intent = new Intent(this, Zerlegung.class);
        startActivity(intent);


    }

    public void buttonTeil(View v) {
        Intent intent = new Intent(this, Teilbarkeit.class);
        startActivity(intent);
    }

    public void buttonBruch(View v) {
        Intent intent = new Intent(this, BruchRechnen.class);
        startActivity(intent);
    }
    public void buttonProzent(View v) {
        Intent intent = new Intent(this, Prozent.class);
        startActivity(intent);
    }
}

