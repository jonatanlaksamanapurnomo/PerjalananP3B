package com.example.t0216025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , IMainActivity {
    protected ListView list;
    protected FoodListAdapter adapter;
    protected  MainPresenter presenter;
    protected Button btnAdd;
    protected EditText edtTitle;
    protected EditText edtDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainPresenter(this);
        this.list=findViewById(R.id.first_foods);
        this.btnAdd=findViewById(R.id.btn_Add);
        this.edtTitle=findViewById(R.id.edt_title);
        this.edtDetail=findViewById(R.id.edt_details);
        this.btnAdd.setOnClickListener(this);

        this.adapter=new FoodListAdapter(this);
        this.presenter.loadData();
        this.presenter.addList("jojo" , "Bukan makanan");
        this.list.setAdapter(this.adapter);
        this.presenter.addList("jojo" , "Bukan Rey");
        this.presenter.deleteList(0);


    }


    @Override
    public void onClick(View view) {
      if(view.getId()==this.btnAdd.getId())
      {
          //this.adapter.addLine(this.edtTitle.getText()+" ");
      }
    }

    @Override
    public void updateList(List<Food> foods) {
        this.adapter.loadData(foods);
    }
}
