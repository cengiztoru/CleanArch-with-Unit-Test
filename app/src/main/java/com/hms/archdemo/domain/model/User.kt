package com.hms.archdemo.domain.model

data class User(
    val fullName: String,
    val email: String,
    val phone: String,
    val gender: Gender,
    val imageUrl: String
)
