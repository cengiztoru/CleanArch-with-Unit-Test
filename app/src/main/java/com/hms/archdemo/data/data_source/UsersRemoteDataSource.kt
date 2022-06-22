package com.hms.archdemo.data.data_source

import com.hms.archdemo.data.remote.service.UserService
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(
    private val userService: UserService
) : BaseRemoteDataSource() {

    suspend fun fetchUsers() = safeApiCall { userService.fetchUsers() }
}