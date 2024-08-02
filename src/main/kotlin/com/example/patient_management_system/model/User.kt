package com.example.patient_management_system.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.sql.Timestamp

@Entity
@Table
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val username: String,

    var password: String,

    val role: String,

    @CreatedDate()
    val created_at: Timestamp? = null

)
