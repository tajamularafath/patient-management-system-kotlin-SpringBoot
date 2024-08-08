package com.example.patient_management_system.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.repository.Temporal
import java.sql.Timestamp

@Entity
@Table
data class Doctor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val fullName: String,

    val doctorEmail: String,

    var password: String,

    val gender: Gender,

    val specialization: String,

    val hospital: String,

    val experience_years: Int,

    var rating: Float,

    val contactInfo: String,

    val address: String,

    val profile_picture: String,

    val biography: String,

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    val created_at: Timestamp? = null

)
