package com.example.lab11zadv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static ListView listView;
    public static ArrayList<String> list;
    public static ArrayAdapter<String> adapter;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        add=findViewById(R.id.homeAddButton);
        list=new ArrayList<>();
        list.add("lista");
        listView=findViewById(R.id.listView);
        adapter=new ArrayAdapter<>(getApplicationContext(),R.layout.show,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(klik);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent);
            }
        });



    }
    private AdapterView.OnItemClickListener klik=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                adapter.notifyDataSetChanged();
        }
    };

}