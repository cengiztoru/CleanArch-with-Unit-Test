package com.hms.archdemo.data.repository

import com.hms.archdemo.common.Result
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.repository.UsersRepository
import com.hms.archdemo.domain.use_case.dummyThrowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeUsersRepository : UsersRepository {

    private val usersFlow = MutableStateFlow<Result<List<UserRemoteModel>>>(Result.Loading)

    override suspend fun fetchUsers(): Flow<Result<List<UserRemoteModel>>> = usersFlow

    fun sendRemoteUsers(users: List<UserRemoteModel>) {
        usersFlow.update {
            Result.Success(users)
        }
    }

    fun removeUsers() {
        usersFlow.update {
            Result.Error(dummyThrowable())
        }
    }

}