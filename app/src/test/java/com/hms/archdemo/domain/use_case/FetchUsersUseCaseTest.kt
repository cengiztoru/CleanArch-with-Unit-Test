package com.hms.archdemo.domain.use_case

import com.hms.archdemo.data.repository.FakeUsersRepository
import com.hms.archdemo.domain.decider.UserDecider
import com.hms.archdemo.domain.mapper.UserMapper
import com.hms.archdemo.util.CoroutineRule
import com.hms.archdemo.util.extensions.shouldEqual
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class FetchUsersUseCaseTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    private val usersRepository = FakeUsersRepository()
    private val userDecider = UserDecider()
    private val userMapper = UserMapper(userDecider)

    private lateinit var fetchUsersUseCase: FetchUsersUseCase

    @Before
    fun setup() {
        fetchUsersUseCase = FetchUsersUseCaseImpl(usersRepository, userMapper)
    }

    @Test
    fun `When starting to fetch users then repository should expose Loading initially`() = runTest {
        com.hms.archdemo.common.Result.Loading shouldEqual fetchUsersUseCase.fetchUsers().first()
    }

    @Test
    fun `Given remote models when fetching users from remote then use case should return remote models as ui models`() =
        runTest {
            val collectJob =
                launch(coroutineRule.testDispatcher) { fetchUsersUseCase.fetchUsers().collect() }
            //Given
            usersRepository.sendRemoteUsers(dummyRemoteModelUserList())

            //When
            val fetchUsersResult = fetchUsersUseCase.fetchUsers().first()

            //Then
            assert(fetchUsersResult is com.hms.archdemo.common.Result.Success)

            val actualData = (fetchUsersUseCase.fetchUsers()
                .first() as com.hms.archdemo.common.Result.Success).data

            val expectedUsers = dummyUserList()

            actualData shouldEqual expectedUsers

            collectJob.cancel()
        }

    @Test
    fun `Given error when fetching users from remote then use case should expose failure`() =
        runTest {
            val collectJob =
                launch(coroutineRule.testDispatcher) { fetchUsersUseCase.fetchUsers().collect() }

            //Given
            usersRepository.removeUsers()

            //When
            val fetchUsersResult = fetchUsersUseCase.fetchUsers().first()

            //Then
            assert(fetchUsersResult is com.hms.archdemo.common.Result.Error)

            val actualException = (fetchUsersUseCase.fetchUsers()
                .first() as com.hms.archdemo.common.Result.Error).exception

            assert(actualException != null)

            val expectedException = dummyThrowable()

            actualException!!.message shouldEqual expectedException.message

            collectJob.cancel()
        }
}