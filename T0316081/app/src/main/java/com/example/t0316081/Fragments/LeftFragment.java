package com.example.t0316081.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t0316081.FragmentListener;
import com.example.t0316081.R;

public class LeftFragment extends Fragment implements View.OnClickListener {
    private TextView homePage,page_2,exit;
    private FragmentListener fragmentListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left , container ,false);
        this.homePage = view.findViewById(R.id.homepage);
        this.page_2 = view.findViewById(R.id.page2);
        this.exit = view.findViewById(R.id.exit);
        this.homePage.setOnClickListener(this);
        this.page_2.setOnClickListener(this);
        this.exit.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.homePage.getId()){
            this.fragmentListener.changePage(1,"");
        }
        else if (view.getId() == this.page_2.getId()){
            this.fragmentListener.changePage(2,"");
        }
        else if(view.getId() == this.exit.getId()){
            this.fragmentListener.closeApplication();
        }

    }
}
