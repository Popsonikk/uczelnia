package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Potegi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potegi);
        Intent intent=getIntent();
        String message= intent.getStringExtra(MainActivity.klucz);
        int i= Integer.parseInt(message);
        int a= (int) Math.pow(i,2);
        int b= (int) Math.pow(i,3);
        TextView textView=(TextView) findViewById(R.id.textView2);
        textView.setText(Integer.toString(a));
        TextView textView1=(TextView) findViewById(R.id.textView3);
        textView1.setText(Integer.toString(b));

    }
}