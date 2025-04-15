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
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/api/medicalHistory/add/{pid}")
	public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory medicalHistory,
											@PathVariable int pid) throws InvalidIDException
	{
		Patient patient=patientService.findById(pid);
		
		if(patient==null)
		{
			throw new InvalidIDException("Enter Valid Patient ID");
		}
		
		medicalHistory.setPatient(patient);
		
		return medicalHistoryService.addMedicalHistory(medicalHistory);
	}
}
