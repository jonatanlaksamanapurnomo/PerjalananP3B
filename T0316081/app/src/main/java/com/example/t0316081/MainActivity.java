package com.example.t0316081;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.t0316081.Fragments.LeftFragment;
import com.example.t0316081.Fragments.MainFragment;
import com.example.t0316081.Fragments.ResultFragment;
import com.example.t0316081.Fragments.SecondFragment;


public class MainActivity extends AppCompatActivity implements FragmentListener {
    private MainFragment mainFragment;
    private SecondFragment secondFragment;
    private Toolbar toolbar;
    private ResultFragment resultFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainFragment = new MainFragment();
        this.secondFragment = new SecondFragment();
        this.fragmentManager = this.getSupportFragmentManager();
        this.toolbar = this.findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.resultFragment =  ResultFragment.newInstance("");
        DrawerLayout drawer = this.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open , R.string.close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        this.changePage(1 ,"");


    }

    @Override
    public void changePage(int page , String text ) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page == 1){
            if(this.mainFragment.isAdded()){
                ft.show(this.mainFragment);
            }
            else{
                ft.add(R.id.fragment_container , this.mainFragment);
            }
            if(this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
        }
        else if(page == 2){

            if(this.mainFragment.isAdded()  ){
                ft.hide(this.mainFragment);
            }

            if(this.secondFragment.isAdded()){
                    ft.show(this.secondFragment);
            }
            else {
                ft.add(R.id.fragment_container , this.secondFragment);
            }
        }
        else if (page ==3 ){
            if(this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
            if(this.secondFragment.isAdded()){
                ft.hide(this.secondFragment);
            }
            if(this.resultFragment.isAdded()){
                ft.show(this.resultFragment);
            }
            else{
                this.resultFragment = ResultFragment.newInstance(text);
               this.resultFragment.show(this.getSupportFragmentManager(),"dialog");
               ft.show(this.mainFragment);
            }

        }


        ft.commit();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}
