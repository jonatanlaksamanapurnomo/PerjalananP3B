package com.example.t0216025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , IMainActivity  {
    protected ListView list;
    protected FoodListAdapter adapter;
    protected  MainPresenter presenter;
    protected Button btnAdd;
    protected EditText edtTitle;
    protected EditText edtDetail;
    protected ImageView star,bin;

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
        this.list.setAdapter(this.adapter);




    }


    @Override
    public void onClick(View view) {
      if(view.getId()==this.btnAdd.getId())
      {
          this.presenter.addList(this.edtTitle.getText().toString(), this.edtDetail.getText().toString());
      }
    }


    @Override
    public void updateList(List<Food> foods) {

        this.adapter.loadData(foods);

    }

}
