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

public class AddContactFragment extends Fragment {

    private Button bnSave;
    EditText Id,Name,Email;

    public AddContactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_add_contact, container, false);
        bnSave=view.findViewById(R.id.button5);
        Id=view.findViewById(R.id.Id);
        Name=view.findViewById(R.id.Name);
        Email=view.findViewById(R.id.Email);
        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=Id.getText().toString();
                String name=Name.getText().toString();
                String email=Email.getText().toString();
                int int_id=Integer.parseInt(id);
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database= contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(int_id,name,email,database);
                contactDbHelper.close();
                Id.setText("");
                Name.setText("");
                Email.setText("");
                Toast.makeText(getActivity(), "Dodano", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}