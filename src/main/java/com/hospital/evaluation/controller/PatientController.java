package com.hospital.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.evaluation.model.MedicalHistory;
import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.model.User;
import com.hospital.evaluation.service.AuthService;
import com.hospital.evaluation.service.MedicalHistoryService;
import com.hospital.evaluation.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	MedicalHistoryService medicalHistoryService;
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/api/patient/add/{mid}/{uid}")
	public Patient addPatient(@RequestBody Patient patient,
								@PathVariable int mid,
								@PathVariable int uid)
	{
		
		MedicalHistory medicalHistory=medicalHistoryService.findById(mid);
		User user=authService.findById(uid);
		
		patient.setMedicalHistory(medicalHistory);
		patient.setUser(user);
		
		return patientService.addPatient(patient);
	}
}
