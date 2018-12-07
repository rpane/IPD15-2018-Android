package com.example.roberto.listofstudents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextStudentId, editTextName, editTextAge;
    Button btnClear, btnRemove, btnAdd, btnAll;

    ArrayList<Student> listOfStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){

        listOfStudents = new ArrayList<>();

        editTextStudentId = findViewById(R.id.etStudentId);
        editTextName = findViewById(R.id.etName);
        editTextAge = findViewById(R.id.etAge);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(this);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnAll = findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);
    }

    @Override
    public void onClick (View view){
        int btnId = view.getId();

        switch(btnId){
            case R.id.btnClear:
                clearEditText();
                break;
            case R.id.btnAdd:
                addToArray();
                break;
            case R.id.btnRemove:
                removeItem();
                break;
            case R.id.btnAll:
                showList();
                break;
        }
    }

    private void showList() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleExtra", listOfStudents);

        Intent i = new Intent(this, show_result.class);
        i.putExtra("IntentKey", bundle);
        startActivity(i);
    }

    private void removeItem() {

        int studentId = Integer.valueOf(editTextStudentId.getText().toString());
        Student x = new Student(studentId, null,0);

        boolean find = false;
        Iterator<Student> iterator = listOfStudents.iterator();
        while (!find && iterator.hasNext()) {
            Student oneStudent = iterator.next();

            if (oneStudent.getStudentID() == studentId) {
                iterator.remove();
                find = true;
            }

            if (find)
                Toast.makeText(this, "The student with the id: " + studentId + " is deleted successfully", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "The student with the id: " + studentId + " does not exist.", Toast.LENGTH_LONG).show();
        }

    }

    private void addToArray() {
        int studentId = Integer.valueOf(editTextStudentId.getText().toString());
        String name = editTextName.getText().toString();
        int age = Integer.valueOf(editTextAge.getText().toString());
        Student x = new Student(studentId,name,age);
        listOfStudents.add(x);

        Toast.makeText(this, x.getStudName() + " Added Successfully", Toast.LENGTH_LONG).show();
    }

    private void clearEditText() {
        editTextAge.setText(null);
        editTextStudentId.setText(null);
        editTextName.setText(null);
    }
}
