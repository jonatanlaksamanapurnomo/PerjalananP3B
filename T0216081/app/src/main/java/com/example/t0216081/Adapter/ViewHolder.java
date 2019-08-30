package com.example.t0216081.Adapter;

import android.view.View;
import android.widget.TextView;

import com.example.t0216081.Model.Food;
import com.example.t0216081.R;

public   class  ViewHolder{
    protected TextView title,desk;

    public ViewHolder(View view){
        this.title = view.findViewById(R.id.tv_title);
        this.desk = view.findViewById(R.id.tv_desc);
    }

    public void updateView(Food food){
        this.title.setText(food.foodName);
        this.desk.setText(food.detail);
    }
}