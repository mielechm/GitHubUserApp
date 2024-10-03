package com.mielechm.githubuserapp.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GitHubDao {
    @Insert
    suspend fun insertUserToDb(user: GitHubUserEntity)

    @Delete
    suspend fun deleteUserFromDb(user: GitHubUserEntity)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<GitHubUserEntity>>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserByIdFromDb(userId: Long): Flow<GitHubUserEntity>
}