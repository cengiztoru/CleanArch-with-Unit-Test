package com.hms.archdemo.data.data_source

import com.hms.archdemo.common.Result
import com.hms.archdemo.common.Result.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart


abstract class BaseRemoteDataSource {

    protected suspend fun <T> safeApiCall(apiCall: suspend () -> T) = flow<Result<T>> {
        val response = apiCall.invoke()
        emit(Success(response))
    }.onStart {
        emit(Loading)
    }.catch {
        emit(Error(exception = it))
    }.flowOn(Dispatchers.IO)

}