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


public class UpdateFragment extends Fragment {

    EditText noteTitle,noteBody,noteNewTitle;
    Button buttom;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_update, container, false);
        noteBody=view.findViewById(R.id.updateNoteBody);
        noteTitle=view.findViewById(R.id.updateNoteTitle);
        buttom=view.findViewById(R.id.updateNoteComfirm);
        noteNewTitle=view.findViewById(R.id.updateNoteNewTitle);
        buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note_new_title=noteNewTitle.getText().toString();
                String note_title=noteTitle.getText().toString();
                String note_body= noteBody.getText().toString();
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database= contactDbHelper.getWritableDatabase();
                contactDbHelper.updateContact(note_title,note_new_title,note_body,database);
                contactDbHelper.close();
                noteNewTitle.setText("");
                noteTitle.setText("");
                noteBody.setText("");
                Toast.makeText(getActivity(), "Update Successfuly", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}