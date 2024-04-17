package com.example.pz_patryk_popek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText new_password,confirm_password;
    Button comfirm_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        new_password=(EditText) findViewById(R.id.editCreatePass);
        confirm_password=(EditText) findViewById(R.id.editComfirmPass);
        comfirm_button=(Button) findViewById(R.id.CreatePassButton);
        comfirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_pass= new_password.getText().toString();
                String confirm_pass= confirm_password.getText().toString();
                if(new_pass.equals("")||confirm_pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Empty Password place", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(new_pass.equals(confirm_pass))
                    {
                        SharedPreferences settings=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor=settings.edit();
                        editor.putString("password",new_pass);
                        editor.apply();
                        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Passwords are not equals", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}