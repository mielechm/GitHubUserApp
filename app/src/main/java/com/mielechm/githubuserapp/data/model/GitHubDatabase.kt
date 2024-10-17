package com.mielechm.githubuserapp.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.data.model.entities.UserDetailsEntity

@Database(
    entities = [GitHubUserEntity::class, UserDetailsEntity::class],
    version = 4
)
abstract class GitHubDatabase: RoomDatabase() {

    abstract fun gitHubDao(): GitHubDao

    companion object {
        val DATABASE_NAME = "github_db"
    }

}