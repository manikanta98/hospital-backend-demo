package com.HospitalDemo.HospitalDemo.Service;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDataService {

    private static List<Patient> Patients= new ArrayList<>();
    private static long idCounter = 0;

    static {
        Patients.add(new Patient(++idCounter, "manikanta","chaluvadi","11-03-1998",23,5,60,"nooo" ));
        Patients.add(new Patient(++idCounter, "Alekhya","chaluvadi","06-08-1999",23,5,60,"nooo" ));
        Patients.add(new Patient(++idCounter, "Ayyapa","chaluvadi","06-08-1999",23,5,60,"nooo" ));
        Patients.add(new Patient(++idCounter, "Prasanthi","chaluvadi","06-08-1999",23,5,60,"nooo" ));
    }

    public List<Patient> findAll() {
        return Patients;
    }
    public Patient save(Patient patient) {
        if (patient.getId() == -1 || patient.getId() == 0) {
            patient.setId(++idCounter);
            Patients.add(patient);
        }
        return patient;

    }




    }
