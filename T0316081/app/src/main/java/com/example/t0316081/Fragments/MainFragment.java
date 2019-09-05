package com.example.t0316081.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t0316081.FragmentListener;
import com.example.t0316081.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private EditText et_show;
    private FragmentListener listener;
    private Button btn_click;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main , container ,false);
        this.et_show = view.findViewById(R.id.et_text);
        this.btn_click = view.findViewById(R.id.btn_click);
        this.btn_click.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_click.getId()){
            this.listener.changePage(3 , this.et_show.getText().toString());

        }

    }
}
