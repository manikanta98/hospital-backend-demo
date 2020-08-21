package com.HospitalDemo.HospitalDemo.Controller;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import com.HospitalDemo.HospitalDemo.repositry.PatientRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = { "http://localhost:1998", "http://localhost:3000" })
@RestController
public class Hello {

    @Autowired
   // private PatientDataService patientDataService;

    @GetMapping("/getpatients")
    public List<Patient> getAllPatinets(){

      return PatientRepositry.getPatients();
   }

}
