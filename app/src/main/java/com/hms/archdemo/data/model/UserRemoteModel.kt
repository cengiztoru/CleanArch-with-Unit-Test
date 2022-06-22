package com.hms.archdemo.data.model

data class UserRemoteModel(
    val gender: String,
    val name: NameRemoteModel,
    val phone: String,
    val email: String,
    val picture: PictureRemoteModel
)

