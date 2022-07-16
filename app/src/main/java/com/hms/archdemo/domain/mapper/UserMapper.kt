package com.hms.archdemo.domain.mapper

import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.decider.UserDecider
import com.hms.archdemo.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor(
    private val decider: UserDecider
) {

    fun mapFrom(userRemoteModel: UserRemoteModel): User = with(userRemoteModel) {
        User(
            fullName = decider.decideFullName(name),
            email = email,
            phone = phone,
            gender = decider.decideGender(gender),
            imageUrl = decider.decideImageUrl(userRemoteModel.picture)
        )
    }
}