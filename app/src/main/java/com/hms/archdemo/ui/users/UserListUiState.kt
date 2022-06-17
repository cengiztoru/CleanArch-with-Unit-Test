package com.hms.archdemo.ui.users

import com.hms.archdemo.domian.use_case.UsersList

data class UserListUiState(
    val isLoading: Boolean = false,
    val users: UsersList = emptyList(),
    val error: String = ""
)
