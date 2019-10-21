package com.example.m0716081;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;
    private Button hitung;
    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.result = findViewById(R.id.result);
        this.hitung = findViewById(R.id.btn_hitung);
        this.input = findViewById(R.id.et_input);
        this.hitung.setOnClickListener(this);

    }


    public void setResult(String s) {
        this.result.setText(s);
        new FetchData(this).execute("2*4");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == this.hitung.getId()) {
            new FetchData(this).execute(this.input.getText().toString());
        }
    }
}
