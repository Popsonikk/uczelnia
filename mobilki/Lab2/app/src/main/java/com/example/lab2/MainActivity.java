package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String klucz="com.example.lab2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void liczPotegi(View viev)
    {
        Intent intent= new Intent(this,Potegi.class);
        EditText editText=(EditText)findViewById(R.id.editTextTextPersonName) ;
        String text= editText.getText().toString();
        intent.putExtra(klucz,text);
        startActivity(intent);
    }
}