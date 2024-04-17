package com.example.lab5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button BnSave, BnView, BnDelete, BnUpdate;
    OnDbOpListener dbOpListener;

    public HomeFragment() {
    }


    public interface OnDbOpListener{
        void dBOpPerformed(int method);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_home, container, false);
        BnSave= view.findViewById(R.id.button);
        BnSave.setOnClickListener(this);
        BnView= view.findViewById(R.id.button2);
        BnView.setOnClickListener(this);
        BnUpdate= view.findViewById(R.id.button3);
        BnUpdate.setOnClickListener(this);
        BnDelete= view.findViewById(R.id.button4);
        BnDelete.setOnClickListener(this);

        return  view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                dbOpListener.dBOpPerformed(0);
                break;
            case R.id.button2:
                dbOpListener.dBOpPerformed(1);
                break;
            case R.id.button3:
                dbOpListener.dBOpPerformed(2);
                break;
            case R.id.button4:
                dbOpListener.dBOpPerformed(3);
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