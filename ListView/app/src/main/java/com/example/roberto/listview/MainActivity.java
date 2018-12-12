package com.example.roberto.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        listView = findViewById(R.id.listView);

        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList("item1","item2", "item3","item4"));

        initializeListView();
    }

    private void initializeListView() {
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(stringArrayAdapter);
    }
}
