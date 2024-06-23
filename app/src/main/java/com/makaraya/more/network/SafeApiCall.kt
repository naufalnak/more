package com.makaraya.more.network

import android.util.Log

suspend fun <T : Any> safeApiCall(block: suspend () -> T): DataResult<T> = try {
    DataResult.Success(block.invoke())
} catch (t: Throwable) {
    Log.e("Api Exception", "$t")
    when (t) {
        is ServerError, is NetworkError -> {
            DataResult.Error("Login failed", networkError = true, exc = t)
        }
        else -> {
            DataResult.Error("Login failed", exc = t)
        }
    }
}

class ServerError(cause: Throwable) : Exception(cause)
class NetworkError : Exception()