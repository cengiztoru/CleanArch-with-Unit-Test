package com.hms.archdemo.domain.repository

import com.hms.archdemo.common.Resource
import com.hms.archdemo.data.model.UserRemoteModel
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun fetchUsers(): Flow<Resource<List<UserRemoteModel>>>
}