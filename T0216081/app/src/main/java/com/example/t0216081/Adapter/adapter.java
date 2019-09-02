package com.example.t0216081.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.t0216081.Model.Food;
import com.example.t0216081.Presenter.MainactivityPresenter;
import com.example.t0216081.R;

import java.util.ArrayList;


public class adapter extends BaseAdapter {
    private ArrayList<Food> data;
    private Activity activity;
    private  MainactivityPresenter presenter;

    public adapter(Activity activity , MainactivityPresenter presenter){
        this.activity= activity;
        this.data = new ArrayList<Food>();
        this.presenter = presenter;
    }

    public void add(Food food){
        this.data.add(food);
        this.notifyDataSetChanged();
    }
    public void loadData(ArrayList<Food> foods){
      this.data = foods;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = this.activity.getLayoutInflater().inflate(R.layout.food_list_item , viewGroup , false);
            viewHolder = new ViewHolder(view ,this.presenter );
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.updateView((Food)this.getItem(i));
        return view;
    }


}

