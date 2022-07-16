package com.hms.archdemo.domain.mapper

import com.google.common.truth.Truth
import com.hms.archdemo.data.model.NameRemoteModel
import com.hms.archdemo.data.model.PictureRemoteModel
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.model.Gender
import org.junit.Test

class UserMapperTest {

    @Test
    fun `given user name and surname separately, when mapOnUserRemoteModel called, then they should concat as fullName`() {

        //given
        val userMapper = UserMapper()
        val userRemoteModel = UserRemoteModel(
            "", NameRemoteModel("Mr", "Cengiz", "TORU"), "", "",
            PictureRemoteModel("", "", "")
        )

        val expectedUserFullName = "Cengiz TORU"

        //when
        val actualUserFullName = userMapper.mapFrom(userRemoteModel).fullName

        //then
        Truth.assertThat(actualUserFullName).isEqualTo(expectedUserFullName)

    }

    @Test
    fun `given male, when mapOnUserRemoteModel called, then should return gender as MALE `() {

        //given
        val userMapper = UserMapper()
        val userRemoteModel = UserRemoteModel(
            "male", NameRemoteModel("", "", ""), "", "",
            PictureRemoteModel("", "", "")
        )

        val expectedGender = Gender.MALE

        //when
        val actualGender = userMapper.mapFrom(userRemoteModel).gender

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedGender)

    }

    @Test
    fun `given female, when mapOnUserRemoteModel called, then should return gender as FEMALE `() {

        //given
        val userMapper = UserMapper()
        val userRemoteModel = UserRemoteModel(
            "female", NameRemoteModel("", "", ""), "", "",
            PictureRemoteModel("", "", "")
        )

        val expectedGender = Gender.FEMALE

        //when
        val actualGender = userMapper.mapFrom(userRemoteModel).gender

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedGender)

    }

    @Test
    fun `given unknow gender, when mapOnUserRemoteModel called, then should return gender as FEMALE `() {

        //given
        val userMapper = UserMapper()
        val userRemoteModel = UserRemoteModel(
            "somethings", NameRemoteModel("", "", ""), "", "",
            PictureRemoteModel("", "", "")
        )

        val expectedGender = Gender.OTHER

        //when
        val actualGender = userMapper.mapFrom(userRemoteModel).gender

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedGender)

    }

}