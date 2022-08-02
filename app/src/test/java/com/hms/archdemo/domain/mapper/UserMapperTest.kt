package com.hms.archdemo.domain.mapper

import android.os.Build
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.decider.UserDecider
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.util.extensions.shouldEqual
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
        actualUser shouldEqual expectedUser
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

        private fun getUserCase1() = arrayOf(
            //Male User
            UserFactory.createUserRemoteModel(gender = "male"),
            UserFactory.createUser(gender = Gender.MALE)
        )

        private fun getUserCase2() = arrayOf(
            //Female User
            UserFactory.createUserRemoteModel(gender = "female"),
            UserFactory.createUser(gender = Gender.FEMALE)
        )

        private fun getUserCase3() = arrayOf(
            //UnDefined Gender
            UserFactory.createUserRemoteModel(gender = "somethings"),
            UserFactory.createUser(gender = Gender.OTHER)
        )
    }

}