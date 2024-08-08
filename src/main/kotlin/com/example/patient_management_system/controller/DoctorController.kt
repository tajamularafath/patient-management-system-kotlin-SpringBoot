package com.example.patient_management_system.controller

import com.example.patient_management_system.model.Doctor
import com.example.patient_management_system.service.DoctorService
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
@RequestMapping("/doctor")
class DoctorController(private val doctorService: DoctorService) {

    @PostMapping("/addDoctor")
    fun addUser(@RequestBody doctor: Doctor): ResponseEntity<Unit> {

    val saveUser =doctorService.saveDoctor(doctor)
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser)
    }

    @GetMapping("/getAllDoctor")
    fun getAllUsers(): List<Doctor> = doctorService.findAllDoctor()

    @GetMapping("/getDoctorById/{id}")
    fun findUserById(@PathVariable id: Long): ResponseEntity<Doctor> {
        val user = doctorService.findDoctorById(id)
        return if(user != null){
            ResponseEntity.ok(user)
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/updateDoctor/{id}")
    fun updateUserById(@PathVariable id : Long, @RequestBody updateDoctor: Doctor): ResponseEntity<Unit> {

        val existingUser = doctorService.findDoctorById(id)
        return if(existingUser != null) {
            val saveUser = existingUser.copy(
                fullName =  updateDoctor.fullName,
                password = existingUser.password,
//                role = updateUser.role,
                created_at = existingUser.created_at
            )
            ResponseEntity.ok(doctorService.saveDoctor(saveUser))
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/deleteDoctorById/{id}")
    fun deleteUserById(@PathVariable id: Long): ResponseEntity<Unit>{
        return if(doctorService.findDoctorById(id) != null){
            doctorService.deleteDoctor(id)
            ResponseEntity.noContent().build()
        } else{
            ResponseEntity.notFound().build()
        }
    }


    }