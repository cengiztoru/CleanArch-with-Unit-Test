package com.hms.archdemo.ui.users

import android.os.Build
import androidx.compose.ui.graphics.Color
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.util.extensions.shouldEqual
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.Config

data class ColorWrapper(val color: Color)

@RunWith(ParameterizedRobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1], manifest = Config.NONE)
class ParameterizedUserItemUiStateTest constructor(
    val userGender: Gender,
    val expectedColorWrapper: ColorWrapper
) {
    @Test
    fun `Given userGender as parameter, When getGenderColor method called, Then should return expectedColor`() {

        //Given
        val expectedColor = expectedColorWrapper.color
        val user = User("", "", "", userGender, "")
        val userItemUiSate = UserItemUiState(user)

        //When
        val actualColor = userItemUiSate.getGenderColor()

        //Then
        actualColor shouldEqual expectedColor
    }

    companion object {
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters(name = "given userGender {0}, expectedColor {1}")
        fun provideParameters(): List<Array<out Any?>> {
            return listOf(
                arrayOf(Gender.MALE, ColorWrapper(Color.Blue)),
                arrayOf(Gender.FEMALE, ColorWrapper(Color.Magenta)),
                arrayOf(Gender.OTHER, ColorWrapper(Color.Magenta)),
            )
        }
    }

}