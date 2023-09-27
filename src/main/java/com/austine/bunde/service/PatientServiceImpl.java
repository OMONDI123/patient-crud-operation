package com.austine.bunde.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.austine.bunde.entity.PatientEntity;
import com.austine.bunde.model.Patient;
import com.austine.bunde.repository.PatientRepository;
import com.austine.bunde.setupExceptions.PatientNotFoundException;
import com.austine.bunde.setupExceptions.ServiceException;
import com.austine.bunde.validation.ValidPatienType;




@Service
public class PatientServiceImpl implements PatientService {
	@Autowired private PatientRepository patientRepository;

	@Override
	public PatientEntity getPatientById(Long patient_id) {
	    try {
	        Optional<PatientEntity> patient = patientRepository.findById(patient_id);
	        if (patient.isPresent()) {
	            return patient.get();
	        } else {
	            throw new PatientNotFoundException("Patient not found with ID: " + patient_id);
	        }
	    } catch (PatientNotFoundException e) {
	        throw e; 
	    } catch (Exception e) {
	        throw new ServiceException("An error occurred while fetching the patient", e);
	    }
	}

	@Override
	public PatientEntity createPatient(Patient patient) {
		try {
			
			 if (!isValidIdentificationType(patient.getIdentificationType())) {
		            throw new IllegalArgumentException("Invalid identification type");
		        }

			PatientEntity patientEntity = new PatientEntity();
			patientEntity.setFirstName(patient.getFirstName());
			patientEntity.setMiddleName(patient.getMiddleName());
			patientEntity.setIdentificationNumber(patient.getIdentificationNumber());
			patientEntity.setIdentificationType(patient.getIdentificationType());
			return patientRepository.save(patientEntity);
			
		} catch (ObjectNotFoundException e) {
			throw new PatientNotFoundException("Could not create patient");
			// TODO: handle exception
		}
	}

	@Override
	public PatientEntity updatePatient(Patient patient) {
		try {
			PatientEntity patientEntity = patientRepository.findById(patient.getId()).get();
			if (!isValidIdentificationType(patient.getIdentificationType())) {
	            throw new IllegalArgumentException("Invalid identification type");
	        }

		patientEntity.setFirstName(patient.getFirstName());
		patientEntity.setMiddleName(patient.getMiddleName());
		patientEntity.setIdentificationNumber(patient.getIdentificationNumber());
		patientEntity.setIdentificationType(patient.getIdentificationType());
		return patientRepository.save(patientEntity);
		
	} catch (ObjectNotFoundException e) {
		throw new PatientNotFoundException("Could not create patient");
		// TODO: handle exception
	}
	}

	@Override
	public PatientEntity deleteById(Long patient_id) {
		try {
			PatientEntity existEntity = patientRepository.findById(patient_id).orElse(null);

			if (existEntity == null) {
				throw new PatientNotFoundException("Patient is not found");
				
			}
			existEntity.setActive(false);
			return patientRepository.save(existEntity);
		}  catch (ObjectNotFoundException e) {
			throw new PatientNotFoundException("Could not find patient");
			// TODO: handle exception
		}
	}

	@Override
	public List<PatientEntity> getAllPatients() {
		try {
			return patientRepository.findAll();
			
		}catch (PatientNotFoundException e) {
			// TODO: handle exception
			throw new PatientNotFoundException("Could not find patient");
		}
	}

	
	
	private boolean isValidIdentificationType(ValidPatienType identificationType) {
	    return Arrays.asList(ValidPatienType.values()).contains(identificationType);
	}
	
	@Override
    public List<PatientEntity> getPatientsByPageAndSize(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PatientEntity> patientPage = patientRepository.findAll(pageable);
        return patientPage.getContent();
    }

	@Override
	public List<PatientEntity> findByIsActive(boolean isActive) {
		try {
			return patientRepository.findByIsActive(isActive);
			
		}catch (PatientNotFoundException e) {
			// TODO: handle exception
			throw new PatientNotFoundException("Could not find patient");
		}
	}

}
