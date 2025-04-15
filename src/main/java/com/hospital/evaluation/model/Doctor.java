package com.hospital.evaluation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
    private Speciality speciality;
	
	public enum Speciality {
        PHYSICIAN,
        ORTHO,
        GYNAC
    }

	public Doctor() {
		super();
	}

	public Doctor(String name, Speciality speciality) {
		super();
		this.name = name;
		this.speciality = speciality;
	}

	public Doctor(int id, String name, Speciality speciality) {
		super();
		this.id = id;
		this.name = name;
		this.speciality = speciality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	
	
}
