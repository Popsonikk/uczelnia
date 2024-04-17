package com.example.pz_patryk_popek;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuNotiFragment extends Fragment implements View.OnClickListener {



    private Button addNoti, showNoti;
    public MenuFragment.ChooseFragment choseFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_menu_noti, container, false);

        addNoti = view.findViewById(R.id.AddNoti);
        addNoti.setOnClickListener(this);
        showNoti = view.findViewById(R.id.ShowNoti);
        showNoti.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AddNoti:
                choseFragment.takeFragment(6);
                break;
            case R.id.ShowNoti:
                choseFragment.takeFragment(7);
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