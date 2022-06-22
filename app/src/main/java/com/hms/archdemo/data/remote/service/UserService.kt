package com.hms.archdemo.data.remote.service

import com.hms.archdemo.data.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET(".")
    suspend fun fetchUsers(
        @Query("results") results: Int = 500
    ): UsersResponse

}