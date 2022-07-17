package com.hms.archdemo.domain.use_case

import com.hms.archdemo.domain.mapper.UserFactory
import com.hms.archdemo.domain.model.Gender

fun maleUser() = UserFactory.createUser(Gender.MALE)
fun femaleUser() = UserFactory.createUser(Gender.FEMALE)
fun undefinedUser() = UserFactory.createUser(Gender.OTHER)
fun fakeUserList() = listOf(
    maleUser(),
    femaleUser(),
    undefinedUser()
)