package com.example.roberto.calculatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class result extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button showBtn, backBtn;

    private ArrayList<Inputs> resultList;
    ArrayAdapter adapter;

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

        Bundle bundle = getIntent().getBundleExtra("IntentKey");
        Serializable bundledInputs = bundle.getSerializable("userInputs");

        resultList = (ArrayList<Inputs>) bundledInputs;

        ListView listResults = (ListView) findViewById(R.id.lvResults);
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, resultList);
        listResults.setAdapter(adapter);







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
