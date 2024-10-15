package com.mielechm.githubuserapp.data.model

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GitHubDao {
    @Insert
    suspend fun insertUserToDb(user: GitHubUserEntity)

    @Delete
    suspend fun deleteUserFromDb(user: GitHubUserEntity)

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserByIdFromDb(userId: Int): Flow<GitHubUserEntity>

    @Upsert
    suspend fun upsertAll(users: List<GitHubUserEntity>)

    @Query("SELECT * FROM users")
    fun pagingSource(): PagingSource<Int, GitHubUserEntity>

    @Query("DELETE FROM users")
    suspend fun clearAll()
}