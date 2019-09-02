package com.example.m0316081.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.m0316081.R;

public class FirstFragment extends Fragment implements View.OnClickListener {
    public TextView tv_title;
    public   FragmentListener listener;
    public Button btn_nextPage;
    public FirstFragment(){

    }
    public static FirstFragment newInstance(String value){
        FirstFragment firstFragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString("title" , value);
        firstFragment.setArguments(args);
        return  firstFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_first , container ,false);
        this.btn_nextPage = view.findViewById(R.id.btn_page);
        this.btn_nextPage.setOnClickListener(this);
        this.tv_title = view.findViewById(R.id.tv_title);
        this.tv_title.setText(this.getArguments().getString("title" , ""));
        return view;
    }
    public void setText(String message){
        this.tv_title.setText(message);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }
        else {
            throw  new  ClassCastException(context.toString() + "Must Implements FragmentListener");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_nextPage.getId()){
            this.listener.changePage(2);
        }
    }
}
