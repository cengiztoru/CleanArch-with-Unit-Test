package com.hms.archdemo.domian.use_case

import com.hms.archdemo.common.Resource
import com.hms.archdemo.domian.model.Gender
import com.hms.archdemo.domian.model.Picture
import com.hms.archdemo.domian.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

typealias UsersList = List<User>
typealias UsersState = Resource<List<User>>
typealias UsersStream = Flow<UsersState>

class GetUsersUserCase @Inject constructor(
    //getUsersRepository todo
) {

    operator fun invoke(): UsersStream = flow {
        try {
            emit(Resource.Loading)
            //call repository funct todo
            delay(1000)
            emit(Resource.Success(getMockUserList()))
        } catch (e: Exception) {
            //todo catching exceptions
        }
    }

    private fun getMockUserList(): UsersList {
        val list = mutableListOf<User>()

        list.add(
            User(
                "Julia Nuñez", "julia.nunez@example.com", "987-969-031",
                Gender.Female,
                Picture(
                    "https://randomuser.me/api/portraits/women/72.jpg",
                    "https://randomuser.me/api/portraits/med/women/72.jpg",
                    "https://randomuser.me/api/portraits/thumb/women/72.jpg"
                )
            )
        )

        list.add(
            User(
                "Martins Viana", "martins.viana@example.com",
                "33) 7470-1214",
                Gender.Male,
                Picture(
                    "https://randomuser.me/api/portraits/men/70.jpg",
                    "https://randomuser.me/api/portraits/med/men/70.jpg",
                    "https://randomuser.me/api/portraits/thumb/men/70.jpg"
                )
            )
        )

        list.add(
            User(
                "Elina Brunet", "lina.brunet@example.com",
                "078 021 03 15",
                Gender.Female,
                Picture(
                    "https://randomuser.me/api/portraits/women/77.jpg",
                    "https://randomuser.me/api/portraits/med/women/77.jpg",
                    "https://randomuser.me/api/portraits/thumb/women/77.jpg"
                )
            )
        )


        list.add(
            User(
                "Ole Schönemann", "ole.schonemann@example.com",
                "0572-9810030",
                Gender.Male,
                Picture(
                    "https://randomuser.me/api/portraits/men/65.jpg",
                    "https://randomuser.me/api/portraits/med/men/65.jpg",
                    "https://randomuser.me/api/portraits/thumb/men/65.jpg"
                )
            )
        )

        return list + list + list + list + list + list + list + list + list + list
    }

}