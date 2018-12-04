package com.example.roberto.buttonimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        radioGroup=findViewById(R.id.radioGroup);
        imageView=findViewById(R.id.imageView);

    }
    public void runMe(View view) {
        int selectedId=radioGroup.getCheckedRadioButtonId();

        switch (selectedId){
            case R.id.radioBtn1: imageView.setImageResource(R.drawable.goofy_confused);
                break;
            case R.id.radioBtn2: imageView.setImageResource((R.drawable.eddy));
                break;
            case R.id.radioBtn3: imageView.setImageResource(R.drawable.double_d);
                break;
        }
    }
}
