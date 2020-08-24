package com.HospitalDemo.HospitalDemo.Service;

import com.HospitalDemo.HospitalDemo.Controller.PatientController;
import com.HospitalDemo.HospitalDemo.Entity.Patient;
import com.HospitalDemo.HospitalDemo.Dao.PatientDao;
import org.springframework.stereotype.Service;


@Service
public class PatientDataService {

    public static Patient save(PatientController patient) {

        PatientDao.addPatient(patient);

        return patient;
    }

    public static Patient update( Integer id, Patient patient){

        PatientDao.updatePatient(id,patient);

        return patient;

    }

    public static Integer delete(Integer id){

        PatientDao.deletePatient(id);

        return id;

    }

//    public void getPatientById(Integer id){
//
//        PatientRepositry.getPatientById(id);
//
//        return;
//    }

}
