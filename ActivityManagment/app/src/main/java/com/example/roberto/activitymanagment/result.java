package com.example.roberto.activitymanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class result extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();
        myGetIntent();
    }

    public void initialize(){
        editText = findViewById(R.id.editText3);
    }

    private void myGetIntent(){
        Float res = getIntent().getFloatExtra("result", 0);
        editText.setText(res.toString());
    }

    public void backBut(View view){
        finish();
    }

}
