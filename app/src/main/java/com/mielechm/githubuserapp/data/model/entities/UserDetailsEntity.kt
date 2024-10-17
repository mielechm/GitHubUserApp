package com.mielechm.githubuserapp.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_details")
data class UserDetailsEntity(
    @PrimaryKey
    val id: Int,
    val login: String,
    val name: String,
    val avatar: String,
    val company: String,
    val bio: String,
    val location: String,
    val followers: Int,
    val createdAt: String
)