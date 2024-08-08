package com.example.patient_management_system.repository

import com.example.patient_management_system.model.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepo: JpaRepository<Patient, Long>