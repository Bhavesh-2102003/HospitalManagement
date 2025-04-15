package com.hospital.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.evaluation.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
