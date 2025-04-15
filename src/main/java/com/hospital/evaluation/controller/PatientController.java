package com.hospital.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/api/patient/add")
	public Patient addPatient(@RequestBody Patient patient)
	{
		return patientService.addPatient(patient);
	}
}
