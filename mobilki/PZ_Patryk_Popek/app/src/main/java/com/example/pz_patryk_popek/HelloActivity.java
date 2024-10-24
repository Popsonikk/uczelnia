package com.example.pz_patryk_popek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class HelloActivity extends AppCompatActivity {

    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        SharedPreferences settings= getSharedPreferences("PREFS",0);
        password= settings.getString("password","");
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if(password.equals(""))
                {
                    intent = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                }
                else
                {
                    intent = new Intent(getApplicationContext(), EnterPasswordActivity.class);
                }
                startActivity(intent);
                finish();

            }
        },2000);
    }

}