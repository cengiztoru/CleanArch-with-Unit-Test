package com.hms.archdemo.ui.users

import com.hms.archdemo.domain.use_case.FakeFetchUsersUseCase
import com.hms.archdemo.domain.use_case.fakeUserListItemsWithUiState
import com.hms.archdemo.util.CoroutineRule
import com.hms.archdemo.util.extensions.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    @Test
    fun `Given creating UserViewModel, Then should exposes loading ui state initially`() {

        //Given
        val fetchUsersUseCase = FakeFetchUsersUseCase()
        val viewModel = UserViewModel(fetchUsersUseCase)

        //Then
        assertTrue(viewModel.uiState.isLoading)
    }

    @Test
    fun `Given fetching users successfully, When getUsers called, Then uiState should update as success`() {

        //Given
        val fetchUsersUseCase = FakeFetchUsersUseCase(isSuccessful = true)
        val viewModel = UserViewModel(fetchUsersUseCase)

        val expectedUiState = UserListUiState(
            isLoading = false,
            fakeUserListItemsWithUiState(),
            error = ""
        )

        //When
        coroutineRule.testDispatcher.scheduler.runCurrent()
        val actualUiState = viewModel.uiState

        //Then
        actualUiState shouldBe expectedUiState

    }

}