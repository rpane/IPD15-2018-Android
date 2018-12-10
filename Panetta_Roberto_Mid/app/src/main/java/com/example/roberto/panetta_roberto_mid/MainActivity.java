package com.example.roberto.panetta_roberto_mid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    private void initialize(){
        editText = findViewById(R.id.editText2);

        radioGroup = findViewById((R.id.rgMenu));
    }
    public void Operate(View view) {
        int btnId = view.getId();
        switch(btnId){
            case R.id.btnOrder:
                show();
                break;
            case R.id.btnFinish:
                finish();
                break;
        }
    }

    private void show() {
        String name = editText.getText().toString();
        int checkRadioButtonID = radioGroup.getCheckedRadioButtonId();
        String item;

        switch (checkRadioButtonID){
            case R.id.rbPoutine:
                item = "Poutine";
                break;
            case R.id.rbChefPoutine:
                item = "Chef Poutine";
                break;
            case R.id.rbSalmon:
                item = "Salmon";
                break;
            case R.id.rbSushi:
                item = "Sushi";
                break;
            case R.id.rbTacos:
                item = "tacos";
                break;
                default: item = "Empty";
        }
        Intent myIntent = new Intent(this, orders2.class);
        myIntent.putExtra("Name", name);
        myIntent.putExtra("Item", item);
        startActivity(myIntent);

    }
}
