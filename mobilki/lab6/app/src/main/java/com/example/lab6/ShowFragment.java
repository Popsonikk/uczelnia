package com.example.lab6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ShowFragment extends Fragment {

 private TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_show, container, false);
        text=view.findViewById(R.id.txt_display);
        readContacts();
        return view;
    }
    private  void readContacts()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getReadableDatabase();
        Cursor cursor=contactDbHelper.readCotacts(database);
        String info="";
        while (cursor.moveToNext())
        {
            String cost=Integer.toString(cursor.getInt(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.COST)));
            String name= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NAME));
            info=info+"\n\n"+"\nName : "+name+"\nCost : "+cost;
        }
        text.setText(info);
        contactDbHelper.close();
    }
}