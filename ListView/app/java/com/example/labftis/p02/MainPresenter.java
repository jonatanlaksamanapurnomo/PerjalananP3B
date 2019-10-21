package com.example.labftis.p02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainPresenter {
    protected List<Food> foods;
    protected IMainActivity ui;

    public MainPresenter(IMainActivity activity){
        this.ui = activity;
        this.foods = new LinkedList<Food>();
    }

    public void loadData(){
        this.foods.addAll(Arrays.asList(MockFood.foodObjectArr));
        this.ui.updateList(this.foods);
    }

    public void deleteList(int position){
        this.foods.remove(position);
        this.ui.updateList(this.foods);
    }

    public void addList(String title, String details){
        this.foods.add(new Food(title,details));
        this.ui.updateList(this.foods);
        this.ui.resetAddForm();
    }

    public void toggleFav(int position){
        Food getFood = this.foods.get(position);
        getFood.setFavourite(!getFood.isFavourite());
        this.ui.updateList(this.foods);
    }
}
