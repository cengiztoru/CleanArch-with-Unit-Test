package com.hms.archdemo.domain.use_case

import com.hms.archdemo.common.Result
import com.hms.archdemo.domain.mapper.UserRemoteModelMapper
import com.hms.archdemo.domain.model.User
import com.hms.archdemo.domain.repository.UsersRepository
import com.hms.archdemo.util.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchUsersUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository,
    private val userRemoteModelMapper: UserRemoteModelMapper,
    // you can use multiple repositories in UseCase classes
    // you can use other UseCase classes, too
) : FetchUsersUseCase {

    override suspend fun fetchUsers(): Flow<Result<List<User>>> {
        return usersRepository.fetchUsers().map {
            it.map { userRemoteModelList ->
                userRemoteModelList.map(userRemoteModelMapper::mapOnUserRemoteModel)
            }
        }
    }

}