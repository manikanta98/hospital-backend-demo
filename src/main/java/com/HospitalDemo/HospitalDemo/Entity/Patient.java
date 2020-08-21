package com.HospitalDemo.HospitalDemo.Entity;

import java.sql.Date;

public class Patient {
    private long p_id;
    private String first_name;
    private String last_name;
    private Date dob;
    private int age;
    private int height;
    private int weight;
    private String facility;

    public Patient(long p_id, String first_name, String last_name, Date dob, int age, int height, int weight, String facility) {
        this.p_id = p_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.facility = facility;
    }

    public Patient() {

    }




    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "p_id=" + p_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob='" + dob + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", facility='" + facility + '\'' +
                '}';
    }
}
