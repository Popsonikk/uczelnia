package com.example.lab5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReadContactsFragment extends Fragment {

    private TextView Txt_display;
    public ReadContactsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_contacts, container, false);
        Txt_display=view.findViewById(R.id.txt_display);
         readContacts();
        return  view;
    }
    private  void readContacts()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getReadableDatabase();
        Cursor cursor=contactDbHelper.readCotacts(database);
        String info="";
        while (cursor.moveToNext())
        {
            String id=Integer.toString(cursor.getInt(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.CONTACT_ID)));
            String name= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.NAME));
            String email= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.EMAIL));
            info=info+"\n\n"+"Id: "+id+"\nName : "+name+"\nEmail : "+email;
        }
        Txt_display.setText(info);
        contactDbHelper.close();
    }
}