package ca.masoudbozorgi.myapplication.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ca.masoudbozorgi.myapplication.R;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        initializeListView();
    }

    private void initializeListView() {

        // 1- Create a ListView with XML array entries
        ListView listView = (ListView) findViewById(R.id.list_options);

        // 2- Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listView,
                                            View itemView,
                                            int position,
                                            long id) {
                        if (position == 0) {

                            Intent intent = new Intent(TopLevelActivity.this,
                                    DrinkCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };

        // 3- Add the listener to the list view
        listView.setOnItemClickListener(itemClickListener);
    }
}