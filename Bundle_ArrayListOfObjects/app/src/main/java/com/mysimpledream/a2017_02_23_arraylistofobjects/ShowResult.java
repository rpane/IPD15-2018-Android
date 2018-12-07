package com.mysimpledream.a2017_02_23_arraylistofobjects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mysimpledream.a2017_02_23_arraylistofobjects.Model.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowResult extends AppCompatActivity {

    TextView textViewResult;
    ArrayList<Student> listOfStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        initialize();
    }

    private void initialize() {
        textViewResult = findViewById(R.id.textViewStudents);

        Bundle bundle = getIntent().getBundleExtra("intentExtra");
        Serializable bundledListOfStudents = bundle.getSerializable("bundleExtra");

        listOfStudents = (ArrayList<Student>) bundledListOfStudents;

        showListOfStudents(listOfStudents);
    }

    private void showListOfStudents(ArrayList<Student> listOfStudents) {
        String str = "";
        for (Student oneStudent : listOfStudents) {
            str = str + oneStudent;
        }
        textViewResult.setText(str);
    }
}
