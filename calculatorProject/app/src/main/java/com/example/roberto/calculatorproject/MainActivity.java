package com.example.roberto.calculatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView title, question;
    EditText screen;
    Button btnGenerate, btnValidate, btnClear, btnDot, btnScore, btnFinish,
    btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnNeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        title = findViewById(R.id.tvTitle);
        question = findViewById(R.id.tvQuestion);
        screen = findViewById(R.id.etScreen);

        btnGenerate = findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(this);

        btnValidate = findViewById(R.id.btnValidate);
        btnValidate.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnDot = findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);

        btnScore = findViewById(R.id.btnScore);
        btnScore.setOnClickListener(this);

        btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(this);

        btnNeg = findViewById(R.id.btnNeg);
        btnNeg.setOnClickListener(this);

        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

    }
    @Override
    public void onClick (View view){

        int btnId = view.getId();
        switch(btnId){
            case R.id.btnClear:
                clearScreen();
                break;
            case R.id.btnValidate:
                validateInput();
                break;
            case R.id.btnFinish:
                finish();
                break;
            case R.id.btnGenerate:
                questGenerate();
                break;
            case R.id.btnScore:
                showScore();
                break;
        }
    }

    private void showScore() {
    }

    private void questGenerate() {
    }

    private void validateInput() {
    }

    private void clearScreen() {
    }

}
