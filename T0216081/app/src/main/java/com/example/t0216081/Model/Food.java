package com.example.t0216081.Model;

public class Food {
    public String foodName , detail;
    public boolean isFav;
    public Food (String foodName){
        this.foodName = foodName;
    }
    public Food (String foodName , String detail){
        this.foodName = foodName;
        this.detail = detail;
        this.isFav = false;
    }

}
