package com.example.pz_patryk_popek;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteFragment extends Fragment {

   Button button;
   EditText title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_delete, container, false);
        button=view.findViewById(R.id.deleteNoteComfirm);
        title=view.findViewById(R.id.deleteNoteTitle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database=contactDbHelper.getWritableDatabase();
                String name=title.getText().toString();
                contactDbHelper.deleteContact(name,database);
                contactDbHelper.close();
                title.setText("");
                Toast.makeText(getActivity(), "Delete Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}