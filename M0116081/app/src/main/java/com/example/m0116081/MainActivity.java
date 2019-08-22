package com.example.m0116081;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected Button btnAction;
    protected EditText editText;
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnAction = this.findViewById(R.id.btn_action);
        this.editText = this.findViewById(R.id.et_edit);
        this.textView = this.findViewById(R.id.tv_show_result);
        this.btnAction.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
//        Log.d("Debug", "onClick: ");
        if(view.getId() == this.btnAction.getId()){
            this.changeText();
        }

    }

    public void changeText(){
        String value = getResources().getString(R.string.value);
        this.textView.setText( value + ": " + this.editText.getText());
    }


}
