package com.example.t0216025;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodListAdapter extends BaseAdapter{
    protected List<Food> itemList;
    protected Activity activity;

    public FoodListAdapter(Activity activity)
    {
        this.activity=activity;
        this.itemList= new ArrayList<Food>();
    }
    @Override
    public int getCount() {
        return this.itemList.size();
    }

    public void loadData(List<Food> foods){
        this.itemList = foods;
    }
    @Override
    public Object getItem(int i) {
        return this.itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    protected class ViewHolder {
        protected TextView title ;

       public ViewHolder(View view)
       {
           this.title=view.findViewById(R.id.tv_title);
       }
       public void updateView(Food food)
       {
           this.title.setText(food.getTitle());
       }
    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(this.activity).inflate(R.layout.food_list_item, parent,false);
        Food currentFood=(Food) this.getItem(i);

        TextView tvTitle=convertView.findViewById(R.id.tv_title);
        tvTitle.setText(currentFood.getTitle());

        TextView tvDetail=convertView.findViewById(R.id.tv_detail);
        tvDetail.setText(currentFood.getDetail());

        ImageView btnStar=convertView.findViewById(R.id.btn_star);

        if(currentFood.isFavorite==true )
        {
            btnStar.setImageResource(android.R.drawable.btn_star_big_on);

        }
        else
        {
            btnStar.setImageResource(android.R.drawable.btn_star_big_off);
        }

        return convertView;
    }

}
