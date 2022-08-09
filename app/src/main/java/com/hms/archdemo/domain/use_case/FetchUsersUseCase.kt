package com.hms.archdemo.domain.use_case

import com.hms.archdemo.common.Resource
import com.hms.archdemo.domain.model.User
import kotlinx.coroutines.flow.Flow

interface FetchUsersUseCase {
    suspend fun fetchUsers(): Flow<Resource<List<User>>>
}