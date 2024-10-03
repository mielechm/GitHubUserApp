package com.mielechm.githubuserapp.data.repository.remote

import com.mielechm.githubuserapp.data.model.model.GitHubUser
import com.mielechm.githubuserapp.network.ApiService
import com.mielechm.githubuserapp.utils.Resource
import io.ktor.client.call.body

class RemoteRepositoryImpl(private val apiService: ApiService) : RemoteRepository {

    override suspend fun getUsersPaginated(): Resource<List<GitHubUser>> {
        val response = try {
            apiService.getUsers().body<List<GitHubUser>>()
        } catch (e: Exception) {
            return Resource.Error(message = e.message.toString())
        }
        return Resource.Success(response)
    }
}