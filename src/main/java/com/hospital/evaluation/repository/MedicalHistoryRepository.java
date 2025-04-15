package com.hospital.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.evaluation.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer>{

}
