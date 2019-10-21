package com.example.labftis.p02;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IMainActivity {
    protected ListView lstFoods;
    protected Button btnAdd;
    protected FoodListAdapter fla;
    protected MainPresenter presenter;
    protected EditText etFoodTitle;
    protected EditText etFoodDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lstFoods = this.findViewById(R.id.lst_foods);
        this.btnAdd = this.findViewById(R.id.btn_add);
        this.etFoodTitle = this.findViewById(R.id.et_food_title);
        this.etFoodDetail = this.findViewById(R.id.et_food_detail);


        this.presenter = new MainPresenter(this);
        this.fla = new FoodListAdapter(this,this.presenter);
        this.lstFoods.setAdapter(this.fla);
        this.presenter.loadData();

        this.btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == this.btnAdd.getId()){
            this.presenter.addList(this.etFoodTitle.getText().toString(),this.etFoodDetail.getText().toString());
        }
    }

    @Override
    public void updateList(List<Food> foods) {
        this.fla.update(foods);
    }

    @Override
    public void resetAddForm(){
        this.etFoodTitle.setText("");
        this.etFoodDetail.setText("");
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.btnAdd.getWindowToken(),0);
    }
}