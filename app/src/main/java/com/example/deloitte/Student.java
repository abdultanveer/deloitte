package com.example.deloitte;

//user defined datatypes
public class Student {
    public static String COLLEGE_NAME = "IIT"; //class memory

    int rollno;
    String name;
    int phno;
    String address;

    public Student(){}
    public Student(int rollno, String name, int phno, String address) {
        this.rollno = rollno;
        this.name = name;
        this.phno = phno;
        this.address = address;
    }

    static int calculateStipend(){ return 100;}

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
