package com.hms.archdemo.domain.use_case

import com.hms.archdemo.domain.mapper.UserFactory
import com.hms.archdemo.domain.model.Gender
import com.hms.archdemo.ui.users.UserItemUiState
import java.io.IOException

/** REMOTE MODEL */
fun maleRemoteUser() = UserFactory.createUserRemoteModel("male")
fun femaleRemoteUser() = UserFactory.createUserRemoteModel("female")
fun undefinedRemoteUser() = UserFactory.createUserRemoteModel("somethings")
fun dummyRemoteModelUserList() = listOf(
    maleRemoteUser(),
    femaleRemoteUser(),
    undefinedRemoteUser()
)


/** USER UI MODEL */
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

fun dummyThrowable() = Throwable("A dummy throwable")