package com.example.m0316081;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.service.autofill.FillEventHistory;

import com.example.m0316081.fragments.FirstFragment;
import com.example.m0316081.fragments.FragmentListener;
import com.example.m0316081.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.secondFragment = SecondFragment.newInstance("horee");
        this.firstFragment = FirstFragment.newInstance("First Fragments");
        this.fragmentManager  = this.getSupportFragmentManager();

        this.changePage(1);
//        this.firstFragment.changeMessage("jojo");
//        this.changePage(2);

    }

    public void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page == 1){
            if(this.firstFragment.isAdded()){
                ft.show(this.firstFragment);
            }
            else{
                ft.add(R.id.fragment_container , this.firstFragment);
            }
            if(this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
        }
        else if(page ==2){
            if(this.firstFragment.isAdded()){
                ft.hide(this.firstFragment);
            }
            if(this.secondFragment.isAdded()){
                ft.show(this.secondFragment);
            }
            else{
                ft.add(R.id.fragment_container , this.secondFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void changeMessage(String message) {
        this.firstFragment.setText(message);

    }
}
