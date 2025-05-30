package com.example.privatellmchat.data.repository

import com.example.privatellmchat.data.api.ChatApi
import com.example.privatellmchat.data.api.ChatMessage
import com.example.privatellmchat.data.api.ChatRequest
import com.example.privatellmchat.data.api.ChatResponse
import com.example.privatellmchat.data.api.LoginRequest
import com.example.privatellmchat.data.api.LoginResponse
import com.example.privatellmchat.data.api.UserInfoResponse
import com.example.privatellmchat.di.NetworkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class AuthRepository {
    private val authApi = NetworkModule.authApi

    fun login(email:String, password:String): Flow<Result<LoginResponse>> = flow {
        try{
            val response = authApi.login(
                request = LoginRequest(email=email, password= password)
            )
            emit(Result.success(response))
        }
        catch (e:Exception){
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)


    fun getUserInfo(userId: String): Flow<Result<UserInfoResponse>> = flow {
        try {
            val response = authApi.getUserInfo(userId)
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

}