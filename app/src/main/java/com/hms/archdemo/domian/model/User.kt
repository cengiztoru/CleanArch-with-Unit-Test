package com.hms.archdemo.domian.model

data class User(
    val fullName:String,
    val email:String,
    val phone:String,
    val gender:Gender,
    val picture: Picture
)
