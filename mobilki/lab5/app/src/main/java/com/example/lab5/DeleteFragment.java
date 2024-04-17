package com.example.lab5;

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
    private EditText Id;
    private Button Button_delete;
    public DeleteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_delete, container, false);
        Id=view.findViewById(R.id.delete_id);
        Button_delete=view.findViewById(R.id.delete_button);
        Button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();

            }
        });

        return view;
    }
    private void deleteContact()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getWritableDatabase();
        int id=Integer.parseInt(Id.getText().toString());
        contactDbHelper.deleteContact(id,database);
        contactDbHelper.close();
        Id.setText("");
        Toast.makeText(getActivity(), "Usunieto", Toast.LENGTH_SHORT).show();
    }
}