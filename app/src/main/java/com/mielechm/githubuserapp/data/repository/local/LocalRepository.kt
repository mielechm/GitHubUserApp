package com.mielechm.githubuserapp.data.repository.local

import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.utils.Resource

interface LocalRepository {

    suspend fun insertUserToDb(user: GitHubUserEntity)

    suspend fun getAllUsersFromDb(): Resource<List<GitHubUserEntity>>

    suspend fun getUserByIdFromDb(): Resource<GitHubUserEntity>

    suspend fun deleteUserFromDb()
}