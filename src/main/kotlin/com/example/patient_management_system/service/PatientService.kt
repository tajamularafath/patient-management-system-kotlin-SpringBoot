package com.example.patient_management_system.service

import com.example.patient_management_system.model.Patient
import com.example.patient_management_system.repository.PatientRepo
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class PatientService(private val patientRepo: PatientRepo) {

    fun findAllPatient(): List<Patient> = patientRepo.findAll()

    fun findPatientById(id: Long): Patient? = patientRepo.findById(id).orElse(null)

    val encoder = BCryptPasswordEncoder()
    fun savePatient(patient: Patient) {
        val encodedPassword = encoder.encode(patient.password)
        patient.password = encodedPassword
        patientRepo.save(patient)
    }

    fun deletePatient(id: Long) = patientRepo.deleteById(id)
}