package com.example.lab4_4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFragment extends Fragment {


    public static  ListView listView;
    public static   ArrayList<String> list;
    public static   ArrayAdapter<String> adapter;

    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view= inflater.inflate(R.layout.fragment_list, container, false);
       list=new ArrayList<>();
       list.add("lista");
       listView=view.findViewById(R.id.listView);
       adapter=new ArrayAdapter<>(view.getContext(),R.layout.showlist,list);
       listView.setAdapter(adapter);
       return  view;
    }




}