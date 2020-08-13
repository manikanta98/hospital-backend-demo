package com.HospitalDemo.HospitalDemo.Controller;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import com.HospitalDemo.HospitalDemo.Service.PatientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:1998"})

//@CrossOrigin(origins = { "http://localhost:1998", "http://localhost:4200" })
@RestController
public class Hello {

//    @Autowired
//    private data PatientDataService ;
//    @GetMapping("/patients")
//    public List<Patient> getAllPatients(){
//        return{
//                data.findAll();
//        }
//
//    }

    @Autowired
    private PatientDataService patientDataService;

    @GetMapping("/getpatients")
    public List<Patient> getAllPatinets(){
        return patientDataService.findAll();
    }

    @PostMapping("/addpatient")
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient ){
        Patient createPatient = patientDataService.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createPatient.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping("/hello")
    public String show(){
        return "hello";
    }

    @RequestMapping("/hi")
    public String showHi(){
        return "Hello Manikanta";
    }



}
