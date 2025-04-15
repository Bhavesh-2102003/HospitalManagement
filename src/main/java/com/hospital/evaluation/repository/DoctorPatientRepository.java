package com.hospital.evaluation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.evaluation.model.DoctorPatient;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer>{

	List<DoctorPatient> findByDoctorId(int did);

}
