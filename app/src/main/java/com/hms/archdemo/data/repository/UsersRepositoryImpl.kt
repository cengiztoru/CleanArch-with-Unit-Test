package com.hms.archdemo.data.repository

import com.hms.archdemo.common.Resource
import com.hms.archdemo.common.extensions.map
import com.hms.archdemo.data.data_source.UsersRemoteDataSource
import com.hms.archdemo.data.model.UserRemoteModel
import com.hms.archdemo.data.model.UsersResponse
import com.hms.archdemo.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersRemoteDataSource: UsersRemoteDataSource,
    // you can use multiple data sources in repository classes
    // you can use other repository classes, too
) : UsersRepository {

    override suspend fun fetchUsers(): Flow<Resource<List<UserRemoteModel>>> {
        return usersRemoteDataSource.fetchUsers().map {
            it.map { usersResponse ->
                mapOnUsersResponse(usersResponse = usersResponse)
            }
        }
    }


    private fun mapOnUsersResponse(usersResponse: UsersResponse): List<UserRemoteModel> =
        usersResponse.results
}