package com.HospitalDemo.HospitalDemo.Entity;

import java.util.Objects;

public class Patient {
    private long id;
    private String firstName;
    private String lastName;
    private String Dob;
    private int age;
    private int height;
    private int weight;
    private String facility;

    public Patient(long id, String firstName, String lastName, String dob, int age, int height, int weight, String facility) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Dob = dob;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.facility = facility;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() &&
                getAge() == patient.getAge() &&
                getHeight() == patient.getHeight() &&
                getWeight() == patient.getWeight() &&
                getFirstName().equals(patient.getFirstName()) &&
                getLastName().equals(patient.getLastName()) &&
                getDob().equals(patient.getDob()) &&
                getFacility().equals(patient.getFacility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getDob(), getAge(), getHeight(), getWeight(), getFacility());
    }
}
