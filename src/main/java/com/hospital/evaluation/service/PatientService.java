package com.hospital.evaluation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	public Patient addPatient(Patient patient) {
		
		return patientRepository.save(patient);
	}

	public Patient findById(int pid) {
		
		Optional<Patient> optional=patientRepository.findById(pid);
		return optional.get();
	}

}
