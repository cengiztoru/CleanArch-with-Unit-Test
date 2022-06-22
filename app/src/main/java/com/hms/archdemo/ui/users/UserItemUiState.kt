package com.hms.archdemo.ui.users

import androidx.compose.ui.graphics.Color
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User

data class UserItemUiState(
    private val user: User
) {
    fun getName() = user.fullName

    fun getEmail() = user.email

    fun getPhone() = user.phone

    fun getGenderColor() = if (user.gender == Gender.MALE) Color.Blue else Color.Magenta

    fun getImageUrl() = user.imageUrl
}
