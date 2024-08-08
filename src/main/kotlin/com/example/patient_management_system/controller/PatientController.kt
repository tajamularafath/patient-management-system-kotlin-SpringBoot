package com.example.patient_management_system.controller

import com.example.patient_management_system.model.Patient
import com.example.patient_management_system.service.PatientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/patient")
class PatientController(private val patientService: PatientService) {

    @PostMapping("/addPatient")
    fun addUser(@RequestBody patient: Patient): ResponseEntity<Unit> {

    val saveUser =patientService.savePatient(patient)
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser)
    }

    @GetMapping("/getAllPatient")
    fun getAllUsers(): List<Patient> = patientService.findAllPatient()

    @GetMapping("/getPatientById/{id}")
    fun findUserById(@PathVariable id: Long): ResponseEntity<Patient> {
        val user = patientService.findPatientById(id)
        return if(user != null){
            ResponseEntity.ok(user)
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/updatePatient/{id}")
    fun updateUserById(@PathVariable id : Long, @RequestBody updateUser: Patient): ResponseEntity<Unit> {

        val existingUser = patientService.findPatientById(id)
        return if(existingUser != null) {
            val saveUser = existingUser.copy(
                username = updateUser.username,
                password = existingUser.password,
//                role = updateUser.role,
                created_at = existingUser.created_at
            )
            ResponseEntity.ok(patientService.savePatient(saveUser))
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/deletePatientById/{id}")
    fun deleteUserById(@PathVariable id: Long): ResponseEntity<Unit>{
        return if(patientService.findPatientById(id) != null){
            patientService.deletePatient(id)
            ResponseEntity.noContent().build()
        } else{
            ResponseEntity.notFound().build()
        }
    }


    }