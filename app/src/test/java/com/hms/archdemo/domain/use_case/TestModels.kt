package com.hms.archdemo.domain.use_case

import com.hms.archdemo.domain.mapper.UserFactory
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.ui.users.UserItemUiState
import java.io.IOException

fun maleUser() = UserFactory.createUser(Gender.MALE)
fun femaleUser() = UserFactory.createUser(Gender.FEMALE)
fun undefinedUser() = UserFactory.createUser(Gender.OTHER)
fun dummyUserList() = listOf(
    maleUser(),
    femaleUser(),
    undefinedUser()
)

fun fakeUserListItemsWithUiState() = dummyUserList().map { user -> UserItemUiState(user) }

fun dummyErrorException() = IOException("An Error Occurred")