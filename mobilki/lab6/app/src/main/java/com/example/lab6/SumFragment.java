package com.example.lab6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SumFragment extends Fragment {
    private TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sum, container, false);
        text=view.findViewById(R.id.sumText);
        sumCost();
        return view;
    }
    private void sumCost()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getReadableDatabase();
        int sum=0;
        Cursor cursor=contactDbHelper.sumCotacts(database);
        while (cursor.moveToNext())
        {
            sum=sum+cursor.getInt(cursor.getColumnIndexOrThrow(ContactContract.ContactEntry.COST));
        }
        text.setText("Suma wydatkow wynosi "+ Integer.toString(sum));
        contactDbHelper.close();
    }
}