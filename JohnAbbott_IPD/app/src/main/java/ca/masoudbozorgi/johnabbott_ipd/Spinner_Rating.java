package ca.masoudbozorgi.johnabbott_ipd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Spinner_Rating extends AppCompatActivity implements
        View.OnClickListener,
        AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_rating);

        initialize();
    }

    Spinner spinnerMeal;
    ImageView imageViewMeal;
    RatingBar ratingBarMeal;

    Button btnAdd, btnShowAll;
    String listMeal[] = {"Salmon", "Poutine", "Sushi", "Tacos"};

    int mealPicture[] = {R.drawable.salmon, R.drawable.poutine, R.drawable.sushi, R.drawable.tacos};
    ArrayList<MealRating> listOfMealRating;

    ArrayAdapter<String> mealAdapter;


    private void initialize() {

        listOfMealRating = new ArrayList<>();

        // Reference to ratingBar.................................
        ratingBarMeal = findViewById(R.id.ratingBar);
        //........................................................


        imageViewMeal = findViewById(R.id.imageView);

        btnAdd = findViewById(R.id.btnAdd);
        btnShowAll = findViewById(R.id.btnShowAll);

        btnAdd.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);

        // Initialize spinner -----------------------------------
        spinnerMeal = findViewById(R.id.spinnerMeal);
        spinnerMeal.setOnItemSelectedListener(this);

        mealAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                listMeal);
        spinnerMeal.setAdapter(mealAdapter);
        //-------------------------------------------------------
    }

    // AdapterView.OnItemSelectedListener ----------------------------------------------------------
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

        // 'i' is index of selected item in spinner,
        // so we can assign the corresponding image reference
        // from our image array to our imageView
        int image = mealPicture[i];
        imageViewMeal.setImageResource(image);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnAdd:
                addMealRating();
                break;

            case R.id.btnShowAll:
                showAllMealRating();
                break;
        }
    }

    private void addMealRating() {

        String meal = spinnerMeal.getSelectedItem().toString();

        // Read ratingBar ....................................
        int rating = (int) ratingBarMeal.getRating();
        //....................................................


        // Create new object and add it to our model array....
        MealRating mealRating = new MealRating(meal, rating);
        listOfMealRating.add(mealRating);
        //....................................................

        // Reset rating bar for next time
        ratingBarMeal.setRating(0);
    }

    private void showAllMealRating() {

        Collections.sort(listOfMealRating);

        StringBuilder sb = new StringBuilder("");

        for (MealRating oneMealRating : listOfMealRating) {
            sb.append(oneMealRating + "\n");
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }
}
