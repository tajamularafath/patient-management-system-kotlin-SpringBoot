package com.example.patient_management_system.controller

import com.example.patient_management_system.model.User
import com.example.patient_management_system.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): ResponseEntity<Unit> {

    val saveUser =userService.saveUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser)
    }

    @GetMapping("/getAllUser")
    fun getAllUsers(): List<User> = userService.findAllUser()

    @GetMapping("/getUserById/{id}")
    fun findUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.findUserById(id)
        return if(user != null){
            ResponseEntity.ok(user)
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/updateUser/{id}")
    fun updateUserById(@PathVariable id : Long, @RequestBody updateUser: User): ResponseEntity<Unit> {

        val existingUser = userService.findUserById(id)
        return if(existingUser != null) {
            val saveUser = existingUser.copy(
                username = updateUser.username,
                password = existingUser.password,
                role = updateUser.role,
                created_at = existingUser.created_at
            )
            ResponseEntity.ok(userService.saveUser(saveUser))
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/deleteUserById/{id}")
    fun deleteUserById(@PathVariable id: Long): ResponseEntity<Unit>{
        return if(userService.findUserById(id) != null){
            userService.deleteUser(id)
            ResponseEntity.noContent().build()
        } else{
            ResponseEntity.notFound().build()
        }
    }


    }