package com.example.pz_patryk_popek;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowNotiFragment extends Fragment {

    private ArrayList<String> list;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_show_noti, container, false);
        list= new ArrayList<>();
        listView= view.findViewById(R.id.listViewNoti);
        adapter= new ArrayAdapter<>(view.getContext(),R.layout.shownotilist,list);
        listView.setAdapter(adapter);
        readDatabase();
        return view;
    }
    void readDatabase()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getReadableDatabase();
        cursor=contactDbHelper.readNotiCotacts(database);
        while (cursor.moveToNext())
        {
            String title= cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntryNoti.NOTI_TITLE))+"\n"
                    +cursor.getString(cursor.getColumnIndexOrThrow(ContactContract.ContactEntryNoti.NOTI_TIME));
            list.add(title);
        }
        adapter.notifyDataSetChanged();
        contactDbHelper.close();
    }
}