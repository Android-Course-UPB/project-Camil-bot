package com.example.privatellmchat.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthentificationApi {
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @GET("user/{user_id}")
    suspend fun getUserInfo(@Path("user_id") userId: String): UserInfoResponse

}

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val userId: String?,
    val status: Number?,
    val errorMessage: String?
)

data class UserInfoResponse(
    val userId: String,
    val email: String,
    val totalMessages: Int,
    val status: Int,
    val errorMessage: String?
)