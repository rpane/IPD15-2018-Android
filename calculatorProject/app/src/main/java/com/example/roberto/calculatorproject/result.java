package com.example.roberto.calculatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class result extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button showBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initialize();
    }
    private void initialize(){
        radioGroup = findViewById(R.id.radioGroup);

        showBtn = findViewById(R.id.btnShow);
        showBtn.setOnClickListener(this);

        backBtn = findViewById(R.id.btnBack);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.btnShow:
                refresh();
                break;
            case R.id.btnBack:
                finish();
                break;
        }
    }

    private void refresh() {
    }
}
