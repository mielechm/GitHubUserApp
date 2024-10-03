package com.mielechm.githubuserapp.data.repository.local

import com.mielechm.githubuserapp.data.model.GitHubDao
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.utils.Resource

class LocalRepositoryImpl(dao: GitHubDao): LocalRepository {
    override suspend fun insertUserToDb(user: GitHubUserEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllUsersFromDb(): Resource<List<GitHubUserEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserByIdFromDb(): Resource<GitHubUserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserFromDb() {
        TODO("Not yet implemented")
    }
}