package com.austine.bunde.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.austine.bunde.entity.PatientEntity;

/**
 * @author Austine Bunde
 *
 * Backend Java Developer
 */

public interface PatientRepository extends  JpaRepository<PatientEntity, Long>{
	
	List<PatientEntity> findByIsActive(boolean isActive);
}

