package com.hms.archdemo.domain.use_case

import com.hms.archdemo.common.Resource
import com.hms.archdemo.common.extensions.map
import com.hms.archdemo.domain.mapper.UserMapper
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchUsersUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository,
    private val userMapper: UserMapper,
    // you can use multiple repositories in UseCase classes
    // you can use other UseCase classes, too
) : FetchUsersUseCase {

    override suspend fun fetchUsers(): Flow<Resource<List<User>>> {
        return usersRepository.fetchUsers().map {
            it.map { userRemoteModelList ->
                userRemoteModelList.map(userMapper::mapFrom)
            }
        }
    }

}