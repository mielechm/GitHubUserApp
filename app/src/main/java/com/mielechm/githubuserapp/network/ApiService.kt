package com.mielechm.githubuserapp.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {
    companion object{
        private const val BASE_URL = "https://api.github.com"
    }

    suspend fun getUsers() = client.get("$BASE_URL/users")
}