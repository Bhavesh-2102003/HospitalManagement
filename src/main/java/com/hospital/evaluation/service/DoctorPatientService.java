package com.hospital.evaluation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.evaluation.model.DoctorPatient;
import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.repository.DoctorPatientRepository;

@Service
public class DoctorPatientService {
	
	@Autowired 
	DoctorPatientRepository doctorPatientRepository;

	public DoctorPatient addAppointment(DoctorPatient doctorPatient) {
		
		return doctorPatientRepository.save(doctorPatient);
	}

	public List<Patient> getPatientByDoctorId(int did) {
		
        List<DoctorPatient> doctorPatients = doctorPatientRepository.findByDoctorId(did);
        return doctorPatients.stream()
                .map(DoctorPatient::getPatient)
                .collect(Collectors.toList());
	}

}
