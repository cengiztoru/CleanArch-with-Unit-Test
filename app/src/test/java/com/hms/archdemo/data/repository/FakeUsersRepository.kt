package com.hms.archdemo.data.repository

import com.hms.archdemo.common.Resource
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.domain.repository.UsersRepository
import com.hms.archdemo.domain.use_case.dummyThrowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeUsersRepository : UsersRepository {

    private val usersFlow = MutableStateFlow<Resource<List<UserRemoteModel>>>(Resource.Loading)

    override suspend fun fetchUsers(): Flow<Resource<List<UserRemoteModel>>> = usersFlow

    fun sendRemoteUsers(users: List<UserRemoteModel>) {
        usersFlow.update {
            Resource.Success(users)
        }
    }

    fun removeUsers() {
        usersFlow.update {
            Resource.Error(dummyThrowable())
        }
    }

}