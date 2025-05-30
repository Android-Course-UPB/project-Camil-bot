package com.example.privatellmchat.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET

interface ChatApi {
    @POST("chat/message")
    suspend fun sendMessage(
        @Body request: ChatRequest
    ): ChatResponse

}

data class ChatRequest(
    val messages: List<Map<String, Any>>,
    val userId: String
)

data class ChatResponse(
    val message: String,
    val timestamp: Long
)

data class ChatMessage(
    val id: String,
    val content: String,
    val isUser: Boolean,
)

