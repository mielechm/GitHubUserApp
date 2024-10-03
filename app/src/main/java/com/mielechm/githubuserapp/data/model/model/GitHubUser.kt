package com.mielechm.githubuserapp.data.model.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUser(
    val id: Long,
    val login: String,
    @SerialName("avatar_url")
    val avatar: String,
    @SerialName("repos_url")
    val repositoriesUrl: String
)
