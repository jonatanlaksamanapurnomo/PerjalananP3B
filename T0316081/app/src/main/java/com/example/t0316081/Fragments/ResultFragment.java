package com.example.t0316081.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.t0316081.R;

public class ResultFragment extends DialogFragment {

    private TextView result;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_dialog , container , false);
        this.result = view.findViewById(R.id.tvResult);
        this.result.setText(this.getArguments().getString("result" ,""));
        return view;
    }
    public static ResultFragment newInstance(String res){
        ResultFragment resultFragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString("result" , res);
        resultFragment.setArguments(args);
        return  resultFragment;
    }

}
