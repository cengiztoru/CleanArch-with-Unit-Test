package com.hms.archdemo.domain.decider

import com.google.common.truth.Truth
import com.hms.archdemo.data.model.NameRemoteModel
import com.hms.archdemo.data.model.PictureRemoteModel
import com.hms.archdemo.domain.model.Gender
import org.junit.Before
import org.junit.Test

class UserDeciderTest {

    private lateinit var decider: UserDecider

    @Before
    fun setUp() {
        decider = UserDecider()
    }

    @Test
    fun `given remote name model, when decideFullName called, then should capitalize first name, uppercase last name and finally merging them`() {

        //given
        val nameRemoteModel = NameRemoteModel("Mr", "cengiz", "toru")

        val expectedUserFullName = "Cengiz TORU"

        //when
        val actualUserFullName = decider.decideFullName(nameRemoteModel)

        //then
        Truth.assertThat(actualUserFullName).isEqualTo(expectedUserFullName)

    }

    @Test
    fun `given male, when decideGender called, then should return gender as MALE `() {

        //given
        val gender = "male"

        val expectedGender = Gender.MALE

        //when
        val actualGender = decider.decideGender(gender)

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedGender)

    }

    @Test
    fun `given female, when decideGender called, then should return gender as FEMALE `() {

        //given
        val gender = "female"

        val expectedGender = Gender.FEMALE

        //when
        val actualGender = decider.decideGender(gender)

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedGender)

    }

    @Test
    fun `given unknown gender, when decideGender called, then should return gender as OHTER `() {

        //given
        val gender = "somethings"

        val expectedGender = Gender.OTHER

        //when
        val actualGender = decider.decideGender(gender)

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedGender)

    }

    @Test
    fun `given PictureRemoteModel, when decideImageUrl called, then should return large image url `() {

        //given
        val pictureRemoteModel =
            PictureRemoteModel("largeImageUrl", "mediumImageUrl", "thumbnailImageUrl")

        val expectedImageUrl = pictureRemoteModel.large

        //when
        val actualGender = decider.decideImageUrl(pictureRemoteModel)

        //then
        Truth.assertThat(actualGender).isEqualTo(expectedImageUrl)

    }

}