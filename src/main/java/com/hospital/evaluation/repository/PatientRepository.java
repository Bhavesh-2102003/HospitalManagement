package com.hospital.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.evaluation.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
