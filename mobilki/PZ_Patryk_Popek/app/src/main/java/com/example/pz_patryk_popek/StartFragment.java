package com.example.pz_patryk_popek;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StartFragment extends Fragment implements View.OnClickListener {


    private Button goNote, goNoti;
    public MenuFragment.ChooseFragment choseFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);
        goNote = view.findViewById(R.id.GoNote);
        goNote.setOnClickListener(this);
        goNoti = view.findViewById(R.id.GoNoti);
        goNoti.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.GoNote:
                choseFragment.takeFragment(4);
                break;
            case R.id.GoNoti:
                choseFragment.takeFragment(5);
                break;
        }
    }
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Activity activity=(Activity) context;
        try {
            choseFragment=(MenuFragment.ChooseFragment) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+"zaimplementuj interfejs");
        }
    }
}