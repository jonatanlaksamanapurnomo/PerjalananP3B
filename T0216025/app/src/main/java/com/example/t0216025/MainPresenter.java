package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPresenter  {
    protected List<Food> foods;
    protected IMainActivity ui;

    public MainPresenter(IMainActivity ui){
        this.ui = ui;
        this.foods = new ArrayList<>();
    }

    public List<Food> getFoods(){
        return this.foods;
    }

    public void loadData()
    {
        for(int i=0 ;i<MockFood.foodObjectArr.length ; i++){
            this.foods.add(MockFood.foodObjectArr[i]);
        }
        this.ui.updateList(this.foods);

    }

    public void deleteList(int position)
    {
        this.foods.remove(position);
        this.ui.updateList(this.foods);

    }

    public void addList(String title,String detail)
    {
        this.foods.add(new Food(title,detail));
        ui.updateList( this.foods);
    }

    public boolean toggleFav()
    {
        return false;
    }

}
