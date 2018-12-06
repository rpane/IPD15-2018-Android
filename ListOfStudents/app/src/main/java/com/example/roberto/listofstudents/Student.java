package com.example.roberto.listofstudents;

import java.io.Serializable;

public class Student implements Serializable {

    private int studentID;
    private String studName;
    private int studAge;

    public Student(int studentID, String studName, int studAge) {
        this.studentID = studentID;
        this.studName = studName;
        this.studAge = studAge;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public int getStudAge() {
        return studAge;
    }

    public void setStudAge(int studAge) {
        this.studAge = studAge;
    }

    @Override
    public String toString() {
        return getStudentID()+" "+getStudName()+" "+getStudAge();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
