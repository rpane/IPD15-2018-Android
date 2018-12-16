package com.example.roberto.calculatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class result extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button showBtn, backBtn;
    EditText userName;
    TextView tvPercent;
    ListView listResults;

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
        userName = findViewById(R.id.etName);
        tvPercent = findViewById(R.id.etPercentage);


        showBtn = findViewById(R.id.btnShow);
        showBtn.setOnClickListener(this);

        backBtn = findViewById(R.id.btnBack);
        backBtn.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("IntentKey");
        Serializable bundledInputs = bundle.getSerializable("userInputs");

        resultList = (ArrayList<Inputs>) bundledInputs;

        listResults = findViewById(R.id.lvResults);
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, resultList);
        listResults.setAdapter(adapter);

        tvPercent.setText(getPercentage(resultList));

    }

    private String getPercentage(ArrayList<Inputs> resultList) {
        int rightCounter =0;
        int total = resultList.size();
        String percent;

       for(Inputs x : resultList){
           if(x.isFlag() == true){
               rightCounter++;
           }
       }
       percent = (int)(100*((double)rightCounter/total)) +"%";
       return percent;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.btnShow:
                refresh();
                break;
            case R.id.btnBack:
                backWithUserName();
                finish();
                break;
        }
    }

    private void backWithUserName() {
        if(userName.getText().length()> 0){
            Intent x = new Intent(this, MainActivity.class);
            x.putExtra("UserName",userName.getText().toString());
            x.putExtra("userPercent", tvPercent.getText().toString());
            startActivity(x);
        }else{
            finish();
        }


    }

    private void refresh() {

        int selectedId = radioGroup.getCheckedRadioButtonId();
        switch (selectedId){
            case R.id.btnAll:
                getAll(resultList);
                break;
            case R.id.btnRight:
                getAllRight(resultList);
                break;
            case R.id.btnWrong:
                getAllWrong(resultList);
                break;
            case R.id.btnSortA:
                sortAscend(resultList);
                break;
            case R.id.btnSortD:
                sortDesc(resultList);
                break;
        }

    }

    private void sortAscend(ArrayList<Inputs> resultList) {
        ArrayList<Inputs> sortedAscending = new ArrayList<>();
        for(Inputs x : resultList){
            if(x.isFlag()){
                sortedAscending.add(sortedAscending.size(),x);

            }else{
                sortedAscending.add(0,x);

            }
        }
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, sortedAscending);
        listResults.setAdapter(adapter);
    }

    private void sortDesc(ArrayList<Inputs> resultList) {
        ArrayList<Inputs> sortedDescend = new ArrayList<>();
        for(Inputs x : resultList){
            if(x.isFlag()){
                sortedDescend.add(0,x);
            }else{
                sortedDescend.add(sortedDescend.size(),x);
            }
        }
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, sortedDescend);
        listResults.setAdapter(adapter);
    }

    private void getAllWrong(ArrayList<Inputs> resultList) {
        ArrayList<Inputs> allWrong = new ArrayList<>();
        for(Inputs x : resultList){
            if(x.isFlag() == false){
                allWrong.add(x);
            }
        }
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, allWrong);
        listResults.setAdapter(adapter);
    }

    private void getAllRight(ArrayList<Inputs> resultList) {
        ArrayList<Inputs> allRight = new ArrayList<>();
        for(Inputs x : resultList){
            if(x.isFlag()){
                allRight.add(x);
            }
        }
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, allRight);
        listResults.setAdapter(adapter);
    }

    private void getAll(ArrayList<Inputs> resultList) {
        ArrayList<Inputs> allInputs = new ArrayList<>();
        for(Inputs x : resultList){
           allInputs.add(x);
        }
        adapter = new ArrayAdapter<Inputs>(this,R.layout.listresults,R.id.ListForResults, allInputs);
        listResults.setAdapter(adapter);
    }
}
