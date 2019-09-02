package com.example.t0216081.Adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t0216081.Model.Food;
import com.example.t0216081.Presenter.MainactivityPresenter;
import com.example.t0216081.R;

public   class  ViewHolder implements View.OnClickListener {
    protected TextView title,desk;
    protected ImageView star;
    protected MainactivityPresenter presenter;

    public ViewHolder(View view , MainactivityPresenter preenter){
        this.title = view.findViewById(R.id.tv_title);
        this.desk = view.findViewById(R.id.tv_desc);
        this.star = view.findViewById(R.id.iv_star);
        this.presenter = preenter;
        this.star.setOnClickListener(this);

    }

    public void updateView(Food food){
        this.title.setText(food.foodName);
        this.desk.setText(food.detail);
        if(food.isFav){
            this.star.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else{
            this.star.setImageResource(android.R.drawable.btn_star_big_off);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.star.getId()){
            this.presenter.toggleFav(0);
        }
    }
}