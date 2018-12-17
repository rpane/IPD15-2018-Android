package com.example.roberto.calculatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title, question;
    EditText screen;
    Button btnGenerate, btnValidate, btnClear, btnDot, btnScore, btnFinish,
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnNeg;

    StringBuilder userInput = new StringBuilder();
    ArrayList<Inputs> arrayList = new ArrayList<>();

    int num1, num2, rndOper;
    double answer;
    String operator;
    Random rnd = new Random();
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        myGetIntent();
    }

    private void myGetIntent(){
        String user = getIntent().getStringExtra("UserName");
        String perc = getIntent().getStringExtra("userPercent");

        if(user == null){
            title.setText("Math Quiz");
        }else{
            title.setText(user +" "+ perc);
        }

    }
    public void initialize() {
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
    public void onClick(View view) {

        int btnId = view.getId();
        switch (btnId) {
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
            case R.id.btn1:
                userInput.append("1");
                screen.setText(userInput);
                break;
            case R.id.btn0:
                userInput.append("0");
                screen.setText(userInput);
                break;
            case R.id.btn2:
                userInput.append("2");
                screen.setText(userInput);
                break;
            case R.id.btn3:
                userInput.append("3");
                screen.setText(userInput);
                break;
            case R.id.btn4:
                userInput.append("4");
                screen.setText(userInput);
                break;
            case R.id.btn5:
                userInput.append("5");
                screen.setText(userInput);
                break;
            case R.id.btn6:
                userInput.append("6");
                screen.setText(userInput);
                break;
            case R.id.btn7:
                userInput.append("7");
                screen.setText(userInput);
                break;
            case R.id.btn8:
                userInput.append("8");
                screen.setText(userInput);
                break;
            case R.id.btn9:
                userInput.append("9");
                screen.setText(userInput);
                break;
            case R.id.btnNeg:
                negative();
                break;
            case R.id.btnDot:
                dot();
                break;

        }
    }

    private void dot() {
        if (userInput.lastIndexOf(".") >= 0) {
            return;
        } else {
            userInput.append(".");
            screen.setText(userInput);
        }

    }

    private void negative() {
        if (userInput.length() > 0) {
            if (userInput.indexOf("-") == -1) {
                userInput.insert(0, "-");
                screen.setText(userInput);
            }else{
                userInput.delete(0,1);
                screen.setText(userInput);
            }
        } else {
            return;
        }

    }

    private void showScore() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("userInputs", arrayList);

        Intent myIntent = new Intent(this, result.class);
        myIntent.putExtra("IntentKey",bundle);
        startActivity(myIntent);
    }

    private void questGenerate() {
        userInput.setLength(0);
        screen.setText(userInput);
        num1 = rnd.nextInt(11-0)+0;
        num2 = rnd.nextInt(11-0)+0;

        rndOper = rnd.nextInt(5-1)+1;

        if(rndOper == 1){
            operator = " + ";
        }else if(rndOper == 2){
            operator = " - ";
        }else if(rndOper == 3){
            operator = " * ";
        }else{
            operator = " / ";
        }

        if(operator == " / " && num2 ==0){
            num2 = rnd.nextInt(11-1)+1;
        }

        question.setText(num1+operator+num2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void validateInput() {
        if(userInput.length() == 0 || question.length() ==0){
            return;
        }
        if(operator == " + "){
            answer = num1 + num2;
        }else if(operator == " - "){
            answer = num1 - num2;
        }else if(operator == " * "){
            answer = num1 * num2;
        }else{
            answer = round((double)num1/num2,2);
        }


        if(answer == Double.parseDouble(screen.getText().toString())){
            Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show();
            flag = true;
        }else{
            Toast.makeText(this,"Wrong! The answer is "+answer,Toast.LENGTH_SHORT).show();
            flag = false;
        }

        String answerStr = answer+"";
        Inputs x = new Inputs(num1,operator,num2,answerStr,screen.getText().toString(),flag);
        arrayList.add(x);
    }

    private void clearScreen() {
        screen.setText("0");
        userInput.setLength(0);
    }

}
