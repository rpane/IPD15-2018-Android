package com.example.roberto.calculatorproject;

public class inputs {
    private int number1;
    private String operator;
    private int number2;
    private double answer;
    private String userAnswer;
    private boolean flag;

    public inputs(int number1, String operator, int number2, double answer, String userAnswer, boolean flag) {
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

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
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
        return super.toString();
    }
}
