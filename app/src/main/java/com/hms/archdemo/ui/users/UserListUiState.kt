package com.hms.archdemo.ui.users

data class UserListUiState(
    val isLoading: Boolean,
    val usersItemUiStates: List<UserItemUiState>,
    val error: String
) {

    companion object {
        fun initial() = UserListUiState(
            isLoading = true,
            usersItemUiStates = emptyList(),
            error = ""
        )
    }
}
