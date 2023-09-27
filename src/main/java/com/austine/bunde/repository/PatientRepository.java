package com.austine.bunde.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.austine.bunde.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long>{
	
	List<PatientEntity> findByIsActive(boolean isActive);

}
