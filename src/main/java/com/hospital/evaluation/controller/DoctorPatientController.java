package com.hospital.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.evaluation.exception.InvalidIDException;
import com.hospital.evaluation.model.Doctor;
import com.hospital.evaluation.model.DoctorPatient;
import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.service.DoctorPatientService;
import com.hospital.evaluation.service.DoctorService;
import com.hospital.evaluation.service.PatientService;

@RestController
public class DoctorPatientController {

	@Autowired
	DoctorPatientService doctorPatientService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/api/appointment/add/{pid}/{did}")
	public DoctorPatient addAppointment(@PathVariable int pid,
										@PathVariable int did) throws InvalidIDException
	{
		Patient patient=patientService.findById(pid);
		Doctor doctor=doctorService.findById(did);
		
		if(doctor==null)
		{
			throw new InvalidIDException("Enter valid doctor id");
		}
		
		if(patient==null)
		{
			throw new InvalidIDException("Enter valid patient id");
		}
		
		DoctorPatient doctorPatient=new DoctorPatient();
		
		doctorPatient.setDoctor(doctor);
		doctorPatient.setPatient(patient);
		
		return doctorPatientService.addAppointment(doctorPatient);
	}
	
	@GetMapping("/api/patients/{did}")
	public List<Patient> getPatientByDoctorId(@PathVariable int did)
	{
		return doctorPatientService.getPatientByDoctorId(did);
	}
}
