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


public class UpdateFragment extends Fragment {

    private EditText Update_id,Update_name,Update_email;
    private Button Update_bn;
    public UpdateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        Update_id=view.findViewById(R.id.UpdateId);
        Update_name=view.findViewById(R.id.UpdateName);
        Update_email=view.findViewById(R.id.UpdateEmail);
        Update_bn=view.findViewById(R.id.update_bn);
        Update_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });
        return  view;
    }
    private void updateContact()
    {
        int id=Integer.parseInt(Update_id.getText().toString());
        String name=Update_name.getText().toString();
        String email=Update_email.getText().toString();
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database=contactDbHelper.getWritableDatabase();
        contactDbHelper.updateContact(id,name,email,database);
        contactDbHelper.close();
        Toast.makeText(getActivity(), "Zaktualizowano", Toast.LENGTH_SHORT).show();
        Update_email.setText("");
        Update_name.setText("");
        Update_id.setText("");
    }
}