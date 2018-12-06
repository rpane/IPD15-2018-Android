package com.example.roberto.listofstudents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class show_result extends AppCompatActivity {
    TextView textView;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        initialize();
    }

    public void initialize(){
        textView = (TextView) findViewById(R.id.tvStudents);
        Bundle bundle = getIntent().getBundleExtra("IntentKey");
        Serializable bundledListOfStudents = bundle.getSerializable("bundleExtra");

        studentList = (ArrayList<Student>) bundledListOfStudents;

        showListOfStudents(studentList);
    }

    private void showListOfStudents(ArrayList<Student> studentList) {
        String str ="";
        for(Student x : studentList){
            str = str + x;
        }
        textView.setText(str);
    }


    public void onBack(View view){
        finish();
    }
}
