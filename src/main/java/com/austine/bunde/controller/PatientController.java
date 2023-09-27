package com.austine.bunde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.austine.bunde.entity.PatientEntity;
import com.austine.bunde.model.Patient;
import com.austine.bunde.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
	
	 @Autowired
	    private PatientService patientService;

	 @GetMapping("/getPatientById/{id}")
	    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Long id) {
	        PatientEntity patient = patientService.getPatientById(id);
	        return new ResponseEntity<>(patient, HttpStatus.OK);
	    }

	    @PostMapping("/create/patient")
	    public ResponseEntity<PatientEntity> createPatient(@RequestBody Patient patient) {
	        PatientEntity createdPatient = patientService.createPatient(patient);
	        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
	    }

	    @PostMapping("/update/patient")
	    public ResponseEntity<PatientEntity> updatePatient(@RequestBody Patient patient) {
	        PatientEntity updatedPatient = patientService.updatePatient(patient);
	        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
	    }

	    @PutMapping("/deActivatePatientByID/{id}")
	    public ResponseEntity<PatientEntity> deleteById(@PathVariable Long id) {
	        PatientEntity deletedPatient = patientService.deleteById(id);
	        return new ResponseEntity<>(deletedPatient, HttpStatus.OK);
	    }

	    @GetMapping("/getAllPatients/list")
	    public ResponseEntity<List<PatientEntity>> getAllPatients() {
	        List<PatientEntity> patients = patientService.getAllPatients();
	        return new ResponseEntity<>(patients, HttpStatus.OK);
	    }

	    @GetMapping("/getActivePatients")
	    public ResponseEntity<List<PatientEntity>> getActivePatients() {
	        List<PatientEntity> patients = patientService.findByIsActive(true);
	        return new ResponseEntity<>(patients, HttpStatus.OK);
	    }
//Typical Pagination implementation
	    @GetMapping("/get/list/{page}/{size}")
	    public ResponseEntity<List<PatientEntity>> getPatientsByPage(
	            @PathVariable int page,
	            @PathVariable int size) {
	        List<PatientEntity> patients = patientService.getPatientsByPageAndSize(page, size);
	        return new ResponseEntity<>(patients, HttpStatus.OK);
	    }

}
