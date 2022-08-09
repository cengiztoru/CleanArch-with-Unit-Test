package com.hms.archdemo.domain.use_case

import app.cash.turbine.test
import com.hms.archdemo.data.repository.FakeUsersRepository
import com.hms.archdemo.domain.decider.UserDecider
import com.hms.archdemo.domain.mapper.UserMapper
import com.hms.archdemo.util.CoroutineRule
import com.hms.archdemo.util.extensions.shouldEqual
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class FetchUsersUseCaseTestWithTurbine {

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
        fetchUsersUseCase.fetchUsers().test {
            awaitItem() shouldEqual com.hms.archdemo.common.Result.Loading
        }
    }

    @Test
    fun `Given remote models when fetching users from remote then use case should expose remote models as ui models`() =
        runTest {
            //Given
            usersRepository.sendRemoteUsers(dummyRemoteModelUserList())

            fetchUsersUseCase.fetchUsers().test {

                //When
                val result = awaitItem()

                //Then
                assert(result is com.hms.archdemo.common.Result.Success)

                val actualUsers = (result as com.hms.archdemo.common.Result.Success).data
                val expectedUsers = dummyUserList()

                actualUsers shouldEqual expectedUsers
            }
        }

    @Test
    fun `Given error when fetching users from remote then use case should expose error message`() =
        runTest {
            //Given
            usersRepository.removeUsers()

            fetchUsersUseCase.fetchUsers().test {

                //When
                val fetchUsersResult = awaitItem()

                //Then
                assert(fetchUsersResult is com.hms.archdemo.common.Result.Error)

                val actualException =
                    (fetchUsersResult as com.hms.archdemo.common.Result.Error).exception

                assert(actualException != null)

                val expectedException = dummyThrowable()

                actualException!!.message shouldEqual expectedException.message

            }

        }
}