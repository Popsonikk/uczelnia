package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    CheckBox checkBox;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editText);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        //button=(Button) findViewById(R.id.button);
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        String tekst=sharedPreferences.getString("editText","");
        editText.setText("tekst");
        boolean check=sharedPreferences.getBoolean("checkBox",false);
        checkBox.setChecked(check);

    }
    public void onClick(View view)
    {
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEdit=sharedPreferences.edit();
        String text=editText.getText().toString();
        prefsEdit.putString("editText",text);
        boolean check=checkBox.isChecked();
        prefsEdit.putBoolean("checkBox",check);
        prefsEdit.commit();
    }
}