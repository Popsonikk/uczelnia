package com.example.lab12_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RotateActivity extends AppCompatActivity {

    Button rotateButton;
    ImageView imageView;
    int numClick=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        imageView= (ImageView) findViewById(R.id.imageView);
        rotateButton=(Button) findViewById(R.id.button);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setPivotX(imageView.getWidth()/2);
                imageView.setPivotY(imageView.getHeight()/2);
                imageView.setRotation(10*numClick);
                numClick++;
            }
        });
    }
}