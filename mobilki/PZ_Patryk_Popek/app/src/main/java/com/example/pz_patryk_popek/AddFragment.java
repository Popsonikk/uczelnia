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


public class AddFragment extends Fragment {

     EditText noteTitle,noteBody;
     Button addButtom;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_add, container, false);
        noteBody=view.findViewById(R.id.addNoteBody);
        noteTitle=view.findViewById(R.id.addNoteTitle);
        addButtom=view.findViewById(R.id.AddNoteComfirm);
        addButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note_title=noteTitle.getText().toString();
                String note_body= noteBody.getText().toString();
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database= contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(note_title,note_body,database);
                contactDbHelper.close();
                noteTitle.setText("");
                noteBody.setText("");
                Toast.makeText(getActivity(), "Add Successfuly", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}