package com.mielechm.githubuserapp.data.mappers

import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.data.model.entities.UserDetailsEntity
import com.mielechm.githubuserapp.data.model.model.GitHubUser
import com.mielechm.githubuserapp.data.model.model.UserDetails

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

fun UserDetails.toUserDetailsEntity(): UserDetailsEntity = UserDetailsEntity(
    id = id,
    login = login,
    name = name,
    avatar = avatar,
    company = company,
    bio = bio,
    location = location,
    followers = followers,
    createdAt = createdAt
)

fun UserDetailsEntity.toUserDetails(): UserDetails = UserDetails(
    id = id,
    login = login,
    name = name,
    avatar = avatar,
    company = company,
    bio = bio,
    location = location,
    followers = followers,
    createdAt = createdAt
)