package com.example.lab8_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText password;
    TextView male, duze, cyfry, ilosc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.editText);
        male = findViewById(R.id.textView2);
        duze = findViewById(R.id.textView3);
        cyfry = findViewById(R.id.textView4);
        ilosc = findViewById(R.id.textView5);
        password.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                String pass = password.getText().toString();
                validate(pass);}
            @Override
            public void afterTextChanged(Editable editable)
            {}
        });

    }
    private void validate(String password) {
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digitalCase = Pattern.compile("[0-9]");
        if(!lowerCase.matcher(password).find())
            male.setTextColor(Color.RED);
        else
            male.setTextColor(Color.GREEN);
        if(!upperCase.matcher(password).find())
            duze.setTextColor(Color.RED);
        else
            duze.setTextColor(Color.GREEN);
        if(!digitalCase.matcher(password).find())
            cyfry.setTextColor(Color.RED);
        else
            cyfry.setTextColor(Color.GREEN);
        if(password.length() < 8)
            ilosc.setTextColor(Color.RED);
        else
            ilosc.setTextColor(Color.GREEN);


    }

}