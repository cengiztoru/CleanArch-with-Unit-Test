package com.hms.archdemo.domain.mapper

import com.hms.archdemo.data.model.NameRemoteModel
import com.hms.archdemo.data.model.PictureRemoteModel
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User

object UserFactory {
    private val FAKE_USER_NAME = NameRemoteModel("mr", "cengiz", "toru")
    private const val FAKE_USER_EMAIL = "ct@ct.com"
    private const val FAKE_USER_PHONE = "+905554443322"
    private val FAKE_PICTURE_MODEL =
        PictureRemoteModel("largeImageUrl", "mediumImageUrl", "thumbnailImageUrl")

    fun createUserRemoteModel(gender: String): UserRemoteModel {
        return UserRemoteModel(
            name = FAKE_USER_NAME,
            gender = gender,
            picture = FAKE_PICTURE_MODEL,
            email = FAKE_USER_EMAIL,
            phone = FAKE_USER_PHONE
        )
    }

    fun createUser(gender: Gender): User {
        return User(
            fullName = "Cengiz TORU",
            gender = gender,
            imageUrl = FAKE_PICTURE_MODEL.large,
            email = FAKE_USER_EMAIL,
            phone = FAKE_USER_PHONE
        )
    }
}