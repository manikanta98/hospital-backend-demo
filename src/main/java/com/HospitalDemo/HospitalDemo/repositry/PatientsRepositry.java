package com.HospitalDemo.HospitalDemo.repositry;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepositry extends JpaRepository<Patient, Long> {

    List<Patient> findAll();

}