package com.hospital.evaluation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hospital.evaluation.model.Doctor;
import com.hospital.evaluation.model.DoctorPatient;
import com.hospital.evaluation.model.Patient;
import com.hospital.evaluation.repository.DoctorPatientRepository;

@ExtendWith(MockitoExtension.class)
public class DoctorPatientServiceTest {

    @Mock
    private DoctorPatientRepository doctorPatientRepository;

    @InjectMocks
    private DoctorPatientService doctorPatientService;

    @Test
    public void testGetPatientsByDoctorId() {
        // Arrange
        Doctor doctor = new Doctor();
        doctor.setId(1);

        Patient patient1 = new Patient();
        patient1.setName("John");

        Patient patient2 = new Patient();
        patient2.setName("Jane");

        DoctorPatient dp1 = new DoctorPatient();
        dp1.setDoctor(doctor);
        dp1.setPatient(patient1);

        DoctorPatient dp2 = new DoctorPatient();
        dp2.setDoctor(doctor);
        dp2.setPatient(patient2);

        List<DoctorPatient> mockList = Arrays.asList(dp1, dp2);
        when(doctorPatientRepository.findByDoctorId(1)).thenReturn(mockList);

        
        List<Patient> patients = doctorPatientService.getPatientByDoctorId(1);

        
        assertEquals(2, patients.size());
        assertEquals("John", patients.get(0).getName());
        assertEquals("Jane", patients.get(1).getName());
    }
}
