package com.HospitalDemo.HospitalDemo.Controller;

import com.HospitalDemo.HospitalDemo.Entity.Patient;
import com.HospitalDemo.HospitalDemo.Service.PatientDataService;
import com.HospitalDemo.HospitalDemo.Dao.PatientDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = { "http://localhost:1998", "http://localhost:3000" })
@RestController
public class patient {

//    @Autowired
   // private PatientDataService patientDataService;

    @GetMapping("/getpatients")
    public List<Patient> getAllPatinets(){

      return PatientDao.getPatients();
   }

    @PostMapping("/addpatients")
    public ResponseEntity<Void> createCourse(@RequestBody Patient patient) {
        Patient patientAdded = PatientDataService.save(patient);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(patientAdded.getP_id())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/updatepatients/{id}")
    public ResponseEntity<Patient> updateCourse( @PathVariable long id,
                                               @RequestBody Patient patient) {
        Patient patientUpdated = PatientDataService.update((int) id, patient);
        return new ResponseEntity<Patient>(patientUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deletepatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Integer id ){

        Integer patientDeleted = PatientDataService.delete(id);

        if (patientDeleted != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getPatientsyById/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable Integer id){

        Patient getPatientById = (Patient) PatientDao.getPatientById(id);
        if (getPatientById != null) {
            return ResponseEntity.noContent().build();
        }
        return (ResponseEntity<Object>) PatientDao.getPatientById(id);

    }

}
