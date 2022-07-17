package com.hms.archdemo.domain.mapper

import android.os.Build
import com.hms.archdemo.data.model.NameRemoteModel
import com.hms.archdemo.data.model.PictureRemoteModel
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.decider.UserDecider
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.util.extensions.shouldBe
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(ParameterizedRobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], manifest = Config.NONE)
class UserMapperTest constructor(
    private val userRemoteModel: UserRemoteModel,
    private val expectedUser: User
) {


    @Test
    fun `Given userRemoteModel, When mapFrom method called, Then should return expectedUser model`() {

        //Given
        val userDecider = UserDecider()
        val userMapper = UserMapper(userDecider)

        //When
        val actualUser = userMapper.mapFrom(userRemoteModel)

        //Then
        actualUser shouldBe expectedUser
    }

    companion object {
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters(name = "given userRemoteModel {0}, expectedUser {1}")
        fun provideParameters(): List<Array<out Any?>> {
            return listOf(
                getUserCase1(),
                getUserCase2(),
                getUserCase3(),
            )
        }

        private val FAKE_USER_NAME = NameRemoteModel("mr", "cengiz", "toru")
        private const val FAKE_USER_EMAIL = "ct@ct.com"
        private const val FAKE_USER_PHONE = "+905554443322"
        private val FAKE_PICTURE_MODEL =
            PictureRemoteModel("largeImageUrl", "mediumImageUrl", "thumbnailImageUrl")

        private fun getUserCase1() = arrayOf(
            //Male User
            baseUserRemoteModelInstance().copy(gender = "male"),
            baseUserInstance().copy(gender = Gender.MALE)
        )

        private fun getUserCase2() = arrayOf(
            //Female User
            baseUserRemoteModelInstance().copy(gender = "female"),
            baseUserInstance().copy(gender = Gender.FEMALE)
        )

        private fun getUserCase3() = arrayOf(
            //UnDefined Gender
            baseUserRemoteModelInstance().copy(gender = "somethings"),
            baseUserInstance().copy(gender = Gender.OTHER)
        )

        private fun baseUserRemoteModelInstance(): UserRemoteModel {
            return UserRemoteModel(
                name = FAKE_USER_NAME,
                gender = "",
                picture = FAKE_PICTURE_MODEL,
                email = FAKE_USER_EMAIL,
                phone = FAKE_USER_PHONE
            )
        }

        private fun baseUserInstance(): User {
            return User(
                fullName = "Cengiz TORU",
                gender = Gender.OTHER,
                imageUrl = FAKE_PICTURE_MODEL.large,
                email = FAKE_USER_EMAIL,
                phone = FAKE_USER_PHONE
            )
        }

    }

}