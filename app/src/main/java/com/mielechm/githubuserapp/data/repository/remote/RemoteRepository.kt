package com.mielechm.githubuserapp.data.repository.remote

import com.mielechm.githubuserapp.data.model.model.GitHubUser
import com.mielechm.githubuserapp.utils.Resource

interface RemoteRepository {

    suspend fun getUsersPaginated(): Resource<List<GitHubUser>>
}