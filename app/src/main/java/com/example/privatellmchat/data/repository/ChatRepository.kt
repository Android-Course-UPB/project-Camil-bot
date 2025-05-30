package com.example.privatellmchat.data.repository

import com.example.privatellmchat.data.api.ChatRequest
import com.example.privatellmchat.data.api.ChatResponse
import com.example.privatellmchat.di.NetworkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ChatRepository {
    private val chatApi = NetworkModule.chatApi

    fun sendMessage(messages: List<Map<String, Any>>, userId: String): Flow<Result<ChatResponse>> = flow {
        try {
            val response = chatApi.sendMessage(
                request = ChatRequest(messages = messages, userId = userId)
            )

            println(response)
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

} 