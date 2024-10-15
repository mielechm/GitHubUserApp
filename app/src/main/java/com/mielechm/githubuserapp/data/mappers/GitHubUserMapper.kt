package com.mielechm.githubuserapp.data.mappers

import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.data.model.model.GitHubUser

fun GitHubUser.toGitHubUserEntity(): GitHubUserEntity = GitHubUserEntity(
    id = id,
    login = login,
    avatar = avatar,
    userUrl = userUrl
)

fun GitHubUserEntity.toGitHubUser(): GitHubUser = GitHubUser(
    id = id,
    login = login,
    avatar = avatar,
    userUrl = userUrl
)