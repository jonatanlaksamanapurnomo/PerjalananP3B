package com.example.t0216081;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.t0216081.Adapter.adapter;
import com.example.t0216081.Model.Food;
import com.example.t0216081.Presenter.MainactivityPresenter;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener,MainactivityPresenter.ImainActivity {

    private MainactivityPresenter presenter;
    private ListView listView;
    private Button add;
    private adapter list_adapter;
    private EditText et_title , et_desk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainactivityPresenter(this);
        this.listView = this.findViewById(R.id.list_foods);
        this.et_title = this.findViewById(R.id.et_1);
        this.et_desk = this.findViewById(R.id.et_2);
        this.add = this.findViewById(R.id.btn);
        this.list_adapter = new adapter(this , presenter);
        this.presenter.loadData();
        this.listView.setAdapter(this.list_adapter);
        this.add.setOnClickListener(this);


    }


    @Override
    public void updateList(ArrayList<Food> food) {
        this.list_adapter.loadData(food);
    }

    @Override
    public void resetAddForm() {
        this.et_title.setText("");
        this.et_desk.setText("");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.add.getId()){
            this.presenter.add(this.et_title.getText().toString() , this.et_desk.getText().toString());
        }
    }


}
