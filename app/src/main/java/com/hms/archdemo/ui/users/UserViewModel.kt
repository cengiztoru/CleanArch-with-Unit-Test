package com.hms.archdemo.ui.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hms.archdemo.common.Resource.*
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.domain.use_case.FetchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val fetchUsersUseCase: FetchUsersUseCase
) : ViewModel() {

    var uiState by mutableStateOf(UserListUiState.initial())
        private set

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            fetchUsersUseCase.fetchUsers().onEach { result ->
                when (result) {
                    is Error -> anErrorOccurred(result.exception?.message.orEmpty())
                    Loading -> setLoading()
                    is Success -> setUsers(result.data)
                }
            }.collect()
        }
    }

    private fun anErrorOccurred(errorMessage: String) {
        uiState = uiState.copy(
            isLoading = false,
            error = errorMessage,
            usersItemUiStates = emptyList()
        )
    }

    private fun setUsers(users: List<User>) {
        uiState = uiState.copy(
            isLoading = false,
            usersItemUiStates = users.map { user -> UserItemUiState(user = user) },
            error = ""
        )
    }

    private fun setLoading() {
        uiState = uiState.copy(
            isLoading = true,
            usersItemUiStates = emptyList(),
            error = ""
        )
    }

}