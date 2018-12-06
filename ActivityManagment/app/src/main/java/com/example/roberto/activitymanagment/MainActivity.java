package com.example.roberto.activitymanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        radioGroup = findViewById((R.id.radioGroup));
    }

    public void operate(View view){
        int btnid = view.getId();

        switch(btnid){
            case R.id.button:
                show();
                break;
            case R.id.button2:
                finish();
                break;
        }
    }

    public void show(){
        float operand1 = Float.valueOf(editText.getText().toString());
        float operand2 = Float.valueOf(editText2.getText().toString());

        int checkRadioButtonID = radioGroup.getCheckedRadioButtonId();
        float result;

        switch(checkRadioButtonID){
            case R.id.add:
                result = operand1 + operand2;
                break;
            case R.id.sub:
                result = operand1 - operand2;
                break;
            case R.id.mult:
                result = operand1 * operand2;
                break;
            case R.id.div:
                result = operand1 / operand2;
                break;
                default:
                    result = operand1 + operand2;
        }

        Intent myIntent = new Intent(this, result.class);
        myIntent.putExtra("result", result);
        startActivity(myIntent);
    }
}

