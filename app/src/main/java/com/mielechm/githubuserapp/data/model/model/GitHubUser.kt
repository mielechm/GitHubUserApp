package com.mielechm.githubuserapp.data.model.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUser(
    val id: Int,
    val login: String,
    @SerialName("avatar_url")
    val avatar: String,
    @SerialName("url")
    val userUrl: String
)
