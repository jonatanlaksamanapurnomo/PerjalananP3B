package com.example.m0216081.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.m0216081.R;

public class StringAdapter extends BaseAdapter {
    private String [] foods;
    private Activity activity;
    public StringAdapter(Activity activity){
        this.activity = activity;
    }

    public void setArr(String [] food){
        this.foods = food;
    }
    public int getCount(){
        return  this.foods.length;
    }
    public Object getItem(int i){
        return this.foods[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void add(String item){
        String[] newArr = new String[this.foods.length+1];
        for(int i = 0 ;i<this.foods.length ; i++){
            newArr[i] = this.foods[i];
        }
        newArr[this.foods.length] = item;
        this.foods = newArr;
        this.notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view  = this.activity.getLayoutInflater().inflate(R.layout.list_item_string , null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.updateView((String) this.getItem(i));

        return  view;
    }

    private  class ViewHolder{
        protected  TextView tv_content;
        public ViewHolder(View view){
            this.tv_content = view.findViewById(R.id.tv_content);
        }
        public void updateView(String text){
            this.tv_content.setText(text);
        }
    }
}

