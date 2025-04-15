package com.hospital.evaluation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.evaluation.model.Doctor;
import com.hospital.evaluation.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	public Doctor addDoctor(Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}
	
	public Doctor findById(int did)
	{
		Optional<Doctor> optional=doctorRepository.findById(did);
		return optional.get();
	}
}
