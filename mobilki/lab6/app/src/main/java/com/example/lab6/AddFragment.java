package com.example.lab6;

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

    private Button button;
    private EditText Cost,Name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        Cost=view.findViewById(R.id.AddCost);
        Name=view.findViewById(R.id.AddName);
        button=view.findViewById(R.id.addbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int  cost=Integer.parseInt(Cost.getText().toString());
               String name=Name.getText().toString();
               ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
               SQLiteDatabase database=contactDbHelper.getWritableDatabase();
               contactDbHelper.addContact(cost,name,database);
               contactDbHelper.close();
               Cost.setText("");
               Name.setText("");
               Toast.makeText(getActivity(), "Dodano", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}