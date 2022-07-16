package com.hms.archdemo.domain.mapper

import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapFrom(userRemoteModel: UserRemoteModel): User = with(userRemoteModel) {
        User(
            fullName = name.first + " " + name.last,
            email = email,
            phone = phone,
            gender = Gender.from(value = gender),
            imageUrl = this.picture.large
        )
    }
}