package com.hms.archdemo.domain.decider

import com.hms.archdemo.common.extensions.capitalizeFirstChar
import com.hms.archdemo.data.model.NameRemoteModel
import com.hms.archdemo.data.model.PictureRemoteModel
import com.hms.archdemo.domain.model.Gender
import javax.inject.Inject

class UserDecider @Inject constructor() {

    fun decideFullName(nameModel: NameRemoteModel): String {
        return nameModel.first.capitalizeFirstChar() + " " + nameModel.last.uppercase()
    }

    fun decideImageUrl(image: PictureRemoteModel): String {
        return image.large
    }

    fun decideGender(gender: String): Gender {
        return Gender.from(value = gender)
    }

}