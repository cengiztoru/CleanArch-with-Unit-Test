package com.hms.archdemo.ui.users

import androidx.compose.ui.graphics.Color
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.util.extensions.shouldBe
import org.junit.Test

class UserItemUiStateTest {

    @Test
    fun `Given MALE user as parameter, When getGenderColor method called, Then should return Blue Color`() {

        //Given
        val expectedColor = Color.Blue
        val user = User("", "", "", Gender.MALE, "")
        val userItemUiSate = UserItemUiState(user)

        //When
        val actualColor = userItemUiSate.getGenderColor()

        //Then
        actualColor shouldBe expectedColor

    }

    @Test
    fun `Given FEMALE user as parameter, When getGenderColor method called, Then should return Magenta Color`() {

        //Given
        val expectedColor = Color.Magenta
        val user = User("", "", "", Gender.FEMALE, "")
        val userItemUiSate = UserItemUiState(user)

        //When
        val actualColor = userItemUiSate.getGenderColor()

        //Then
        actualColor shouldBe expectedColor

    }

    @Test
    fun `Given OTHER gender user as parameter, When getGenderColor method called, Then should return Magenta Color`() {

        //Given
        val expectedColor = Color.Magenta
        val user = User("", "", "", Gender.OTHER, "")
        val userItemUiSate = UserItemUiState(user)

        //When
        val actualColor = userItemUiSate.getGenderColor()

        //Then
        actualColor shouldBe expectedColor

    }


}