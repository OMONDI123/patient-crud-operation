package com.austine.bunde.service;

import java.util.List;

import com.austine.bunde.entity.PatientEntity;
import com.austine.bunde.model.Patient;

public interface PatientService {
	public PatientEntity getPatientById(Long patient_id);
	
	public PatientEntity createPatient(Patient patient);
	
	public PatientEntity updatePatient(Patient patient);
	
	public PatientEntity deleteById(Long patient_id);
	
	public List<PatientEntity> getAllPatients();
	
	public List<PatientEntity> findByIsActive(boolean isActive);
	
	public List<PatientEntity> getPatientsByPageAndSize(int page, int size);

}
