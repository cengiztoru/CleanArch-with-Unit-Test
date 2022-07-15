package com.hms.archdemo.common.extensions

import com.hms.archdemo.common.Result

inline fun <T, R> Result<T>.map(transform: (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success(
            transform(data)
        )
        is Result.Error -> Result.Error(exception)
        is Result.Loading -> Result.Loading
    }
}