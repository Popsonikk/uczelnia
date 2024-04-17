package com.example.pz_patryk_popek;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ShowFragment extends Fragment {


    private TextView textView;
    private ArrayList<String> list;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragment_show, container, false);
       textView=view.findViewById(R.id.showRecord);
       list= new ArrayList<>();
       listView= view.findViewById(R.id.listView);
       adapter= new ArrayAdapter<>(view.getContext(),R.layout.showlist,list);
       listView.setAdapter(adapter);
       readDatabase();
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String title= (String) listView.getItemAtPosition(i);
               cursor.moveToFirst();
               readBody(title);

           }
       });
       return view;
    }
    void readDatabase()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getReadableDatabase();
        cursor=contactDbHelper.readCotacts(database);
        while (cursor.moveToNext())
        {
            String title= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NOTE_TITLE));
            list.add(title);
        }
        cursor.moveToFirst();
        adapter.notifyDataSetChanged();
        contactDbHelper.close();
    }
    void readBody(String title)
    {
        String cursorTitle= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NOTE_TITLE));
        if(cursorTitle.equals(title))
        {
            String body=cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NOTE_BODY));
            textView.setText(body);
            return;
        }
        while (cursor.moveToNext())
        {
            cursorTitle= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NOTE_TITLE));
            if(cursorTitle.equals(title))
            {
                String body=cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NOTE_BODY));
                textView.setText(body);
                return;
            }
        }
    }
}