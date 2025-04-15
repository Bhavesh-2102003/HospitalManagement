package com.hospital.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.evaluation.model.Doctor;
import com.hospital.evaluation.service.DoctorService;

@RestController
public class DoctorContoller {
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/api/doctor/add")
	public Doctor addDoctor(@RequestBody Doctor doctor)
	{
		return doctorService.addDoctor(doctor);
	}
}

