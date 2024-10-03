package com.mielechm.githubuserapp.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class GitHubUserEntity(
    @PrimaryKey
    val id: Long,
    val login: String,
    val avatar: String,
    val repositoryUrl: String
)
