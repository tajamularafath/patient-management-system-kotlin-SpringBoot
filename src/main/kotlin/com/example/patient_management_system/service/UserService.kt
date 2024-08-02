package com.example.patient_management_system.service

import com.example.patient_management_system.model.User
import com.example.patient_management_system.repository.UserRepo
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService( private val userRepo: UserRepo) {

    fun findAllUser(): List<User> = userRepo.findAll()

    fun findUserById(id: Long): User? = userRepo.findById(id).orElse(null)

    val encoder = BCryptPasswordEncoder()
    fun saveUser(user: User) {
        val encodedPassword = encoder.encode(user.password)
        user.password = encodedPassword
        userRepo.save(user)
    }

    fun deleteUser(id: Long) = userRepo.deleteById(id)
}