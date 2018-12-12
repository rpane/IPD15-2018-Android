package com.example.roberto.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DrinkCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        initializeList();
    }

    private void initializeList(){
        ListView listDrinks = (ListView) findViewById(R.id.list_drinks);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, Drink.drinks);

        listDrinks.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(this," + position + ",id =" + id," )
                    }
                }
    }
}
