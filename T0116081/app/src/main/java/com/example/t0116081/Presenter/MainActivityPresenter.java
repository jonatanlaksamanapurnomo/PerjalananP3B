package com.example.t0116081.Presenter;
import android.widget.Button;

import com.example.t0116081.Model.Angka;

public class MainActivityPresenter {
    private View view;
    private Angka num;

    public MainActivityPresenter(View view){
        this.view = view;
        this.num = new Angka();
    }

    public void updateCounter(int counter){
        num.setAngka(counter);
        String res = Integer.toString(counter);
        this.view.updateTextView(res);
    }
    public void changeButtonTitle(Button b , String s ){
        b.setText(s);
    }

    public interface View{
        void updateTextView(String s);
    }

}
