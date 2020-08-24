package com.HospitalDemo.HospitalDemo.Service;

import com.HospitalDemo.HospitalDemo.Dao.PatientDao;
import com.HospitalDemo.HospitalDemo.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDaO;


//    public Patient save(Patient patient) {
//
//        patientDaO.addPatient((PatientController)patient);
//        return patient;
//    }
public Patient save(Patient patient) {

    patientDaO.addPatient(patient);

    return patient;
}

public Patient updatePatient(Integer id, Patient patient){

    patientDaO.updatePatient(id,patient);

    return patient;
}

    public List<Patient> findAll() {
        return patientDaO.getPatients();
    }

    public List<Patient> deleteById(Integer p_id) {

        return patientDaO.deletePatient(p_id);
    }

    public List<Patient> findById(Integer p_id) {

        return patientDaO.getPatientById(p_id);

    }
}