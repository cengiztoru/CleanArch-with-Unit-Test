package com.hms.archdemo.domain.use_case

import com.hms.archdemo.common.Result
import com.hms.archdemo.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeFetchUsersUseCase(
    private val isSuccessful: Boolean = true
) : FetchUsersUseCase {

    override suspend fun fetchUsers(): Flow<Result<List<User>>> {
        return flow {
            if (isSuccessful) {
                emit(
                    Result.Success(fakeUserList())
                )
            } else {
                emit(Result.Error(fakeErrorException()))
            }
        }
    }
}