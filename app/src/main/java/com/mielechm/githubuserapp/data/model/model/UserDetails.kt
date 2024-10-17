package com.mielechm.githubuserapp.data.model.model

data class UserDetails(
    val id: Int = 0,
    val login: String = "",
    val name: String = "",
    val avatar: String = "",
    val company: String = "",
    val bio: String = "",
    val location: String = "",
    val followers: Int = 0,
    val createdAt: String = ""
)
