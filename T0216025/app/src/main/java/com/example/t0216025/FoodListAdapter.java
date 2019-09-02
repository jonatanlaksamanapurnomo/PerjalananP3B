package com.example.t0216025;

import android.app.Activity;
import android.util.Log;
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
        this.notifyDataSetChanged();
    }
    @Override
    public Object getItem(int i) {
        return this.itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.food_list_item , parent , false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView( (Food)this.getItem(i));
        return convertView;
    }
    protected class ViewHolder  {
        protected TextView tvText , tvDesk ;
        protected ImageView star,bin;


        public ViewHolder (View view) {

            this.tvText = view.findViewById(R.id.tv_title) ;
            this.tvDesk = view.findViewById(R.id.tv_detail);
            this.star = view.findViewById(R.id.btn_star);

        }

        public void updateView(Food food) {
            this.tvText.setText(food.title);
            this.tvDesk.setText(food.detail);
            if(food.isFavorite == true)
            {
                this.star.setImageResource(android.R.drawable.btn_star_big_on);
            }
            else
            {
                this.star.setImageResource(android.R.drawable.btn_star_big_off);
            }

        }
    }

}
