package com.hms.archdemo.domain.repository

import com.hms.archdemo.common.Result
import com.hms.archdemo.data.model.UserRemoteModel
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun fetchUsers(): Flow<Result<List<UserRemoteModel>>>
}