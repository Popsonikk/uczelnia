package com.example.pz_patryk_popek;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment implements View.OnClickListener {

    public ChooseFragment chooseFragment;
    private Button addButton, showButton,deleteButton,updateButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        addButton=view.findViewById(R.id.AddNote);
        addButton.setOnClickListener(this);
        showButton=view.findViewById(R.id.ShowNote);
        showButton.setOnClickListener(this);
        deleteButton=view.findViewById(R.id.DeleteNote);
        deleteButton.setOnClickListener(this);
        updateButton=view.findViewById(R.id.UpdateNote);
        updateButton.setOnClickListener(this);

        return  view;
    }

    public interface ChooseFragment{
        void takeFragment(int i);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.AddNote:
                chooseFragment.takeFragment(0);
                break;
            case R.id.ShowNote:
                chooseFragment.takeFragment(1);
                break;
            case R.id.UpdateNote:
                chooseFragment.takeFragment(2);
                break;
            case R.id.DeleteNote:
                chooseFragment.takeFragment(3);
                break;

        }

    }
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Activity activity=(Activity) context;
        try {
            chooseFragment=(ChooseFragment) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+"zaimplementuj interfejs");
        }
    }


}