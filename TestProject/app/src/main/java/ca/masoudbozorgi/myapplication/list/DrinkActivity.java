package ca.masoudbozorgi.myapplication.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ca.masoudbozorgi.myapplication.R;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";

    TextView name, description;
    ImageView photo;

    Drink drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        initialize();
        getMyIntent();
        populateData(drink);
    }

    private void initialize() {
        name = (TextView)findViewById(R.id.name);
        description = (TextView)findViewById(R.id.description);
        photo = (ImageView)findViewById(R.id.photo);
    }

    private void getMyIntent() {

        // 1- Get the drink from the intent
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        drink = Drink.drinks[drinkId];
    }


    private void populateData(Drink drink) {

        // 2- Populate the drink name
        name.setText(drink.getName());

        // 3- Populate the drink description
        description.setText(drink.getDescription());

        // 4- Populate the drink image
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}