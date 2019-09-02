package com.example.t0216081.Presenter;
import com.example.t0216081.Mock.MockFood;
import com.example.t0216081.Model.Food;
import java.util.ArrayList;

public class MainactivityPresenter   {
    private ArrayList<Food> data;
    private ImainActivity ui;
    public MainactivityPresenter( ImainActivity view){
        this.ui = view;
        this.data = new ArrayList<Food>();
    }

    public void loadData(){
        for(int i = 0; i< MockFood.foodObjectArr.length ; i++){
            this.data.add(MockFood.foodObjectArr[i]);
        }
        this.ui.updateList(this.data);
    }
    public void add(String title , String detail){
        Food food = new Food(title , detail);
        this.data.add(food);
        this.ui.resetAddForm();
        this.ui.updateList(this.data);
    }
    public void deleteList(int i ){
        this.data.remove(i);
        this.ui.updateList(this.data);
    }
    public void toggleFav(int i){
       this.data.get(i).isFav = !this.data.get(i).isFav;
       this.ui.updateList(this.data);

    }

//    using inner class
    public  interface ImainActivity{
        void updateList(ArrayList<Food> food);
        void resetAddForm();
    }

}
