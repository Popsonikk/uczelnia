package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter <Integer> adapter;
    private final String klucz="com/example/lab3";
    ArrayList<Integer> numbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView) findViewById(R.id.listView);
        numbers=new ArrayList<>();
        adapter= new ArrayAdapter<>(this,R.layout.element,numbers);
        list.setAdapter(adapter);
        list.setOnItemClickListener(klik);

    }
    private AdapterView.OnItemClickListener klik= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View viev,int n,long j)
        {

            AlertDialog.Builder komunikat= new AlertDialog.Builder(adapter.getContext());
            komunikat.setMessage("Czy skopiować liczbę do schowka");
            komunikat.setPositiveButton("kopiuj", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Integer itemValue = (Integer) list.getItemAtPosition(n);
                    Toast.makeText(getApplicationContext(),"Skopiowano: "+itemValue,Toast.LENGTH_SHORT).show();
                    ClipboardManager kopiuj= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clip= ClipData.newPlainText("Skopiowana wartosc",Integer.toString(itemValue) );
                    kopiuj.setPrimaryClip(clip);
                }
            });
            komunikat.setNeutralButton("losuj nową", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    numbers.set(n,(int)(Math.random() * 1000000));
                    adapter.notifyDataSetChanged();

                }
            });
            komunikat.setNegativeButton("nie", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(),"nic nie robie",Toast.LENGTH_SHORT).show();

                }
            });
            AlertDialog alertDialog=komunikat.create();
            alertDialog.show();




        }
    };
    public void close(View view)
    {
        AlertDialog.Builder komunikat= new AlertDialog.Builder(this);
        komunikat.setMessage("Jestes pewien");
        komunikat.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAndRemoveTask();
            }
        });
        komunikat.setNegativeButton("nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"milo ze zostales",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=komunikat.create();
        alertDialog.show();
    }
    public void losujkolejne10(View view)
    {

        for(int i=0;i<10;i++)
            numbers.add((int)(Math.random() * 1000000));

        //list.setAdapter(adapter);
       // list.setOnItemClickListener(klik);
        adapter.notifyDataSetChanged();
    }
    public void losuj10(View view)
    {

        numbers.clear();
        for(int i=0;i<10;i++)
            numbers.add((int)(Math.random() * 1000000));

        //list.setAdapter(adapter);
        // list.setOnItemClickListener(klik);
        adapter.notifyDataSetChanged();
    }


}
