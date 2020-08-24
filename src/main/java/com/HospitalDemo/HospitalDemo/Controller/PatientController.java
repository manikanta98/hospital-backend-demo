package com.HospitalDemo.HospitalDemo.Controller;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import com.HospitalDemo.HospitalDemo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = { "http://localhost:1998", "http://localhost:3000" })
@RestController
public class PatientController extends Patient {

    //@Autowired
    // private PatientDataService patientDataService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/getpatients")
    public List<Patient> getAllPatinets() {

        return patientService.findAll();
    }

    @PostMapping("/addpatients")
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient) {
        Patient patientAdded = patientService.save(patient);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(patientAdded.getP_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/updatepatients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
//        Patient patientUpdated = patientService.save(patient);
        Patient patientUpdated = patientService.updatePatient(id, patient);
        return new ResponseEntity<Patient>(patientUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deletepatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Integer id) {

        List<Patient> patientDeleted = patientService.deleteById(id);

        if (patientDeleted != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



   @GetMapping("/getPatientsyById/{id}")
  public List<Patient> getPatientById(@PathVariable Integer id){

//      List<Patient>getPatientById  = patientService.findById(id);
//      if (getPatientById != null) {
//           return ResponseEntity.noContent().build();
//        }
       return patientService.findById(id);
}
//    @GetMapping("/getPatientsyById/{id}")
//    public List<Patient> getPatient( @PathVariable long id) {
//        return patientService.findById(id);
//    }
//
}
