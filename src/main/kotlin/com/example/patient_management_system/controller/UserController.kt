package com.example.patient_management_system.controller

import com.example.patient_management_system.model.User
import com.example.patient_management_system.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): ResponseEntity<User>{
    val saveUser =userService.saveUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser)
    }

}