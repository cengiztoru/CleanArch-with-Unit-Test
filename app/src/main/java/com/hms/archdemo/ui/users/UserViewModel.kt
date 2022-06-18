package com.hms.archdemo.ui.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hms.archdemo.common.Resource
import com.hms.archdemo.domian.model.User
import com.hms.archdemo.domian.use_case.GetUsersUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUserCase: GetUsersUserCase
) : ViewModel() {
    private val _uiState = mutableStateOf(UserListUiState())
    val uiState: State<UserListUiState> = _uiState

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersUserCase().onEach { resource ->
            when (resource) {
                is Resource.Loading -> setLoading()
                is Resource.Success -> setUsers(resource.data ?: emptyList())
                is Resource.Error -> anErrorOccurred(resource.message ?: "")
            }
        }.launchIn(viewModelScope)
    }

    private fun anErrorOccurred(errorMessage: String) {
        updateUiState(UserListUiState(error = errorMessage))
    }

    private fun setUsers(data: List<User>) {
        updateUiState(UserListUiState(users = data))
    }

    private fun setLoading() {
        updateUiState(UserListUiState(true))
    }


    private fun updateUiState(newState: UserListUiState) {
        _uiState.value = newState
    }
}