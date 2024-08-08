package com.example.patient_management_system.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.repository.Temporal
import java.sql.Timestamp

@Entity
@Table
data class Patient(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val patientId: Long,

    val username: String,

    val fullname: String,

    var password: String,

    val age: String,

    val gender: Gender,

    val contact: String,

    val address: String,

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    val created_at: Timestamp? = null

)
