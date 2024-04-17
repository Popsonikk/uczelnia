package com.example.lab12_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] choices;
    ListView choicesListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources= getResources();
        choices= resources.getStringArray(R.array.choices_array);
        choicesListView=(ListView) findViewById(R.id.listView);

        choicesListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,choices));
        choicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        startActivity(new Intent(MainActivity.this,ScaleActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,RotateActivity.class));
                        break;
                }
            }
        });

    }
}