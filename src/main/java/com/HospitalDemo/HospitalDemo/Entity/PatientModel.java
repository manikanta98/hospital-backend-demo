package com.HospitalDemo.HospitalDemo.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class PatientModel {

    private long id;
    private String firstName;
    private String lastName;
    private String Dob;
    private int age;
    private int height;
    private int weight;
    private String facility;

    public PatientModel(long id, String firstName, String lastName, String dob, int age, int height, int weight, String facility) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Dob = dob;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.facility = facility;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "dob", nullable = false)
    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    @Column(name = "age",nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "height",nullable = false)
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column(name = "facility",nullable = false)
    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Dob='" + Dob + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", facility='" + facility + '\'' +
                '}';
    }
}
