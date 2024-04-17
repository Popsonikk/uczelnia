package com.example.lab6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button addBn ,showBn,sumBn;
    OnDbOpListener dbOpListener;

    public HomeFragment() {
    }


    public interface OnDbOpListener{
        void dBOpPerformed(int method);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        addBn=view.findViewById(R.id.homeAddButton);
        addBn.setOnClickListener(this);
        showBn=view.findViewById(R.id.homeShowButton);
        showBn.setOnClickListener(this);
        sumBn=view.findViewById(R.id.homeSumButton);
        sumBn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.homeAddButton:
                dbOpListener.dBOpPerformed(0);
                break;
            case R.id.homeShowButton:
                dbOpListener.dBOpPerformed(1);
                break;
            case R.id.homeSumButton:
                dbOpListener.dBOpPerformed(2);
                break;
        }


    }
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Activity activity=(Activity) context;
        try {
            dbOpListener=(OnDbOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+"zaimplementuj interfejs");
        }
    }
}