package com.hospital.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.evaluation.exception.InvalidIDException;
import com.hospital.evaluation.model.MedicalHistory;
import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.service.MedicalHistoryService;
import com.hospital.evaluation.service.PatientService;

@RestController
public class MedicalHistoryController {
	
	@Autowired
	MedicalHistoryService medicalHistoryService;
	
		
	
	@PostMapping("/api/medicalHistory/add")
	public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
	    return medicalHistoryService.addMedicalHistory(medicalHistory);
	}
}
