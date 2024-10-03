package com.mielechm.githubuserapp.di

import com.mielechm.githubuserapp.data.model.GitHubDao
import com.mielechm.githubuserapp.data.repository.local.LocalRepositoryImpl
import com.mielechm.githubuserapp.data.repository.remote.RemoteRepositoryImpl
import com.mielechm.githubuserapp.network.ApiService
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRemoteRepository(get()) }
    single { provideLocalRepository(get()) }
}

fun provideRemoteRepository(apiService: ApiService): RemoteRepositoryImpl {
    return RemoteRepositoryImpl(apiService)
}

fun provideLocalRepository(dao: GitHubDao): LocalRepositoryImpl {
    return LocalRepositoryImpl(dao)
}