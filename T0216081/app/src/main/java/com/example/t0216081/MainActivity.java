package com.example.t0216081;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.t0216081.Adapter.adapter;
import com.example.t0216081.Mock.MockFood;
import com.example.t0216081.Model.Food;
import com.example.t0216081.Presenter.MainactivityPresenter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements  MainactivityPresenter.ImainActivity {

    private MainactivityPresenter presenter;
    private ListView listView;
    private Button add;
    private adapter list_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainactivityPresenter(this);
        this.listView = this.findViewById(R.id.list_foods);
        this.add = this.findViewById(R.id.btn);
        this.list_adapter = new adapter(this);
        this.presenter.loadData();
        this.listView.setAdapter(this.list_adapter);
//        this.presenter.deleteList(0);

    }


    @Override
    public void updateList(ArrayList<Food> food) {
        this.list_adapter.loadData(food);
    }
}
