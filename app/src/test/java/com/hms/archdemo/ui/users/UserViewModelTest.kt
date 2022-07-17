package com.hms.archdemo.ui.users

import com.hms.archdemo.domain.use_case.FakeFetchUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Given creating UserViewModel, Then should exposes loading ui state initially`() {

        //Given
        val fetchUsersUseCase = FakeFetchUsersUseCase()
        val viewModel = UserViewModel(fetchUsersUseCase)

        //Then
        assertTrue(viewModel.uiState.isLoading)
    }

}