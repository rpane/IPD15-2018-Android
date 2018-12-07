package com.mysimpledream.a2017_02_23_arraylistofobjects.Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by masoud on 2017-02-23.
 */

public class Student implements Serializable {

    private int studentID;
    private String name;
    private int age;


    public Student() {
    }

    public Student(int studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "studentID: " + studentID +
                "name: " + name +
                "age: " + age + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }


//    @Override
//    public boolean equals(Object obj) {
    // Version 1
//        return ((Student) obj).getStudentID() == studentID;

    // Version 2
//        Student otherStudent = (Student) obj;
//        if (studentID == otherStudent.getStudentID())
//            return true;
//        else
//            return false;
//    }
}
