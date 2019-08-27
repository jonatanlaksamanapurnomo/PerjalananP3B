package com.example.m0216081;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.m0216081.Adapter.StringAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView list_foods;
    private String[] data;
    private EditText et_1;
    private Button button;
    private StringAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.et_1 = findViewById(R.id.et_1);
        this.button = findViewById(R.id.btn);
        this.list_foods = this.findViewById(R.id.list_foods);
        this.data = new String[10];
        for(int i = 0 ; i<10 ; i++){
            this.data[i] = "Bakso";
        }
        this.adapter  = new StringAdapter(this);
        this.adapter.setArr(this.data);
        this.list_foods.setAdapter(this.adapter);
        this.button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.button.getId()){
            this.adapter.add(this.et_1.getText() + "");
        }
    }
}
