package com.example.bloomreachsdk.data

sealed class Response<T> {
    data class Success<T>(val data: T): Response<T>()
    data class Error<T>(val error: Throwable): Response<T>()
}