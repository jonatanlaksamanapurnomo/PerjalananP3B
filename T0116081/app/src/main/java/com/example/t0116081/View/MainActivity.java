package com.example.t0116081.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.t0116081.Presenter.MainActivityPresenter;
import com.example.t0116081.R;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener , MainActivityPresenter.View {
    private MainActivityPresenter presenter;
    private TextView center_tv;
    private Button button_1,button_2,button_3,button_4,actionButton,resetButton;
    private int counter;
    private boolean clickStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainActivityPresenter(this);
        this.center_tv = this.findViewById(R.id.center_tv);
        this.button_1 = this.findViewById(R.id._1);
        this.button_2 = this.findViewById(R.id._2);
        this.button_3 = this.findViewById(R.id._3);
        this.button_4 = this.findViewById(R.id._4);
        this.actionButton = this.findViewById(R.id.actionButton);
        this.resetButton = this.findViewById(R.id.resetButton);
        this.clickStatus= true;
        this.resetButton.setOnClickListener(this);
        this.actionButton.setOnClickListener(this);
        this.button_1.setOnClickListener(this);
        this.button_2.setOnClickListener(this);
        this.button_3.setOnClickListener(this);
        this.button_4.setOnClickListener(this);
        this.counter = 0;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == this.resetButton.getId()){
            this.presenter.updateCounter(counter = 0);
        }
        else if (view.getId() == this.actionButton.getId()){
            if(this.clickStatus){
                this.presenter.changeButtonTitle(this.actionButton , "-");
                this.clickStatus = !this.clickStatus;
            }
            else{
                this.presenter.changeButtonTitle(this.actionButton , "+");
                this.clickStatus = !this.clickStatus;
            }
        }
        else if(view.getId() == this.button_1.getId()){
            if(this.clickStatus){
                this.presenter.updateCounter(counter++);
            }
            else{
                this.presenter.updateCounter(counter--);
            }

        }
        else if(view.getId() == this.button_2.getId()){
            if(this.clickStatus){
                this.presenter.updateCounter(counter+=2);
            }
            else{
                this.presenter.updateCounter(counter-=2);
            }

        }
        else if(view.getId() == this.button_3.getId()){
            if(this.clickStatus){
                this.presenter.updateCounter(counter+=3);
            }
            else{
                this.presenter.updateCounter(counter-=3);
            }

        }
        else if(view.getId() == this.button_4.getId()){
            if(this.clickStatus){
                this.presenter.updateCounter(counter+=4);
            }
            else{
                this.presenter.updateCounter(counter-=4);
            }

        }
    }

    @Override
    public void updateTextView(String s) {
        this.center_tv.setText(s);
    }
}
