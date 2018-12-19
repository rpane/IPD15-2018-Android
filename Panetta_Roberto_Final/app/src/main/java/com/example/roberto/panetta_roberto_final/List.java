package com.example.roberto.panetta_roberto_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class List extends AppCompatActivity implements View.OnClickListener{

    ListView listResults;
    private ArrayList<Customer> resultList;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initialize();
    }

    private void initialize(){
        Bundle bundle = getIntent().getBundleExtra("IntentKey");
        Serializable bundledInputs = bundle.getSerializable("customers");

        resultList = (ArrayList<Customer>) bundledInputs;
        listResults = findViewById(R.id.lvResults);

        adapter = new ArrayAdapter<Customer>(this,R.layout.listresults,R.id.ListForResults, resultList);
        listResults.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Bundle bundle = new Bundle();
                            bundle.putSerializable("customers", resultList);

                            Intent intent = new Intent(List.this, Balance.class);
                            intent.putExtra("position", position);
                            intent.putExtra("IntentKey",bundle);
                            startActivity(intent);
                    }
                };
        listResults.setOnItemClickListener(itemClickListener);
    }
    @Override
    public void onClick(View v) {

    }
}
