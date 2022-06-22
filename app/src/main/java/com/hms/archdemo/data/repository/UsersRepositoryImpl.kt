package com.hms.archdemo.data.repository

import com.hms.archdemo.common.Result
import com.hms.archdemo.data.data_source.UsersRemoteDataSource
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.data.model.UsersResponse
import com.hms.archdemo.domain.repository.UsersRepository
import com.hms.archdemo.util.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersRemoteDataSource: UsersRemoteDataSource
) : UsersRepository {

    override suspend fun fetchUsers(): Flow<Result<List<UserRemoteModel>>> {
        return usersRemoteDataSource.fetchUsers().map {
            it.map { usersResponse ->
                mapOnUsersResponse(usersResponse = usersResponse)
            }
        }
    }


    private fun mapOnUsersResponse(usersResponse: UsersResponse): List<UserRemoteModel> =
        usersResponse.results
}