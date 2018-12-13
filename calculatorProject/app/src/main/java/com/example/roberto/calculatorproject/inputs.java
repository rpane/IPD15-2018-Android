package com.example.roberto.calculatorproject;

import java.io.Serializable;

public class Inputs implements Serializable {
    private int number1;
    private String operator;
    private int number2;
    private String answer;
    private String userAnswer;
    private boolean flag;

    public Inputs(int number1, String operator, int number2, String answer, String userAnswer, boolean flag) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.flag = flag;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    @Override
    public String toString() {
        if(flag == true){
            return String.format("Right!\n%d %s %d = %s\nUser Entered: %s",getNumber1(),getOperator(),getNumber2(), getAnswer(),getUserAnswer());
        }else{
            return  String.format("Wrong!\n%d %s %d = %s\nUser Entered: %s",getNumber1(),getOperator(),getNumber2(), getAnswer(),getUserAnswer());
        }
    }
}
