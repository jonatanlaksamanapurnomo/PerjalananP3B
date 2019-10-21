package com.example.labftis.p02;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class FoodListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Food> foods;
    private MainPresenter presenter;

    public FoodListAdapter(Activity activity, MainPresenter presenter){
        this.activity =  activity;
        this.presenter = presenter;
        this.foods = new LinkedList<Food>();
    }

    @Override
    public int getCount() {
        return this.foods.size();
    }

    @Override
    public Object getItem(int i) {
        return this.foods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.food_list_item, parent, false);
            viewHolder = new ViewHolder(convertView,this.presenter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView((Food)this.getItem(i),i);

        // returns the view for the current row
        return convertView;
    }

    public void update(List<Food> getFoods){
        this.foods.clear();
        this.foods.addAll((getFoods));
        this.notifyDataSetChanged();
    }

    private class ViewHolder implements View.OnClickListener{
        protected TextView title;
        protected TextView detail;
        protected ImageButton btnDelete;
        protected MainPresenter presenter;
        protected ImageView ivFavourite;
        private int position;

        public ViewHolder(View view, MainPresenter presenter) {
            this.title = view.findViewById(R.id.tv_food_title);
            this.detail = view.findViewById(R.id.tv_food_detail);
            this.btnDelete = view.findViewById(R.id.btn_delete);
            this.ivFavourite = view.findViewById(R.id.iv_favourite);

            this.btnDelete.setOnClickListener(this);
            view.setOnClickListener(this);
            this.presenter = presenter;
        }

        @Override
        public void onClick(View view) {
            //Log.d(this.getClass().getCanonicalName(), "Position :"+position);
            if (view.getId() == this.btnDelete.getId()){
                this.presenter.deleteList(this.position);
            }else{
                this.presenter.toggleFav(this.position);
            }

        }

        public void updateView(Food food,int position){
            this.position = position;
            this.title.setText(food.getTitle());
            this.detail.setText(food.getDetails());
            if (food.isFavourite()){
                this.ivFavourite.setImageResource(android.R.drawable.btn_star_big_on);
            }else{
                this.ivFavourite.setImageResource(android.R.drawable.btn_star_big_off);
            }

        }
    }
}
