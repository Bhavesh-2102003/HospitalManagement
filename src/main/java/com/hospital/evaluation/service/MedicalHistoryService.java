package com.hospital.evaluation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.evaluation.model.MedicalHistory;
import com.hospital.evaluation.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {
	
	@Autowired
	MedicalHistoryRepository medicalHistoryRepository;

	public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) {
		
		return medicalHistoryRepository.save(medicalHistory);
	}

}
