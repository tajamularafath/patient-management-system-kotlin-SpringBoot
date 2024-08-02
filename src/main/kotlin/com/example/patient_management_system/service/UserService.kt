package com.example.patient_management_system.service

import com.example.patient_management_system.model.User
import com.example.patient_management_system.repository.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService( private val userRepo: UserRepo) {

    fun findAllUser(): List<User> = userRepo.findAll()

    fun findUserById(id: Long): User? = userRepo.findById(id).orElse(null)

    fun saveUser(user: com.example.patient_management_system.model.User): User = userRepo.save(user)

    fun deleteUser(id: Long) = userRepo.deleteById(id)
}