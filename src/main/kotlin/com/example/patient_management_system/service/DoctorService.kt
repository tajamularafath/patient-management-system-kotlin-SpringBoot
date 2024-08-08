package com.example.patient_management_system.service

import com.example.patient_management_system.model.Doctor
import com.example.patient_management_system.repository.DoctorRepo
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class DoctorService(private val doctorRepo: DoctorRepo) {

    fun findAllDoctor(): List<Doctor> = doctorRepo.findAll()

    fun findDoctorById(id: Long): Doctor? = doctorRepo.findById(id).orElse(null)

    val encoder = BCryptPasswordEncoder()
    fun saveDoctor(doctor: Doctor) {
        val encodedPassword = encoder.encode(doctor.password)
        doctor.password = encodedPassword
        doctorRepo.save(doctor)
    }

    fun deleteDoctor(id: Long) = doctorRepo.deleteById(id)
}