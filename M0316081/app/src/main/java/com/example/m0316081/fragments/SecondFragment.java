package com.example.m0316081.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.m0316081.R;

public class SecondFragment extends Fragment implements View.OnClickListener {
    private  FragmentListener listener;
    private Button btn_submit;
    private EditText pesan;
    private  TextView tv_2;
    public SecondFragment(){

    }

    public static  SecondFragment newInstance(String title){
        SecondFragment secondFragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString("title" , title);
        secondFragment.setArguments(args);
        return  secondFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second , container , false);
         this.tv_2 = view.findViewById(R.id.tv_title2);
        this.btn_submit = view.findViewById(R.id.btn_submit);
        this.pesan = view.findViewById(R.id.et_message);
        this.btn_submit.setOnClickListener(this);
        this.tv_2.setText(getArguments().getString("title" , ""));
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  FragmentListener){
            this.listener = (FragmentListener) context;
        }
        else{
            throw  new ClassCastException(context.toString() + "Must Implements FragmentListener");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_submit.getId()){
            String message = this.pesan.getText().toString();
            this.listener.changePage(1);
            this.listener.changeMessage(message);
        }
    }
}
