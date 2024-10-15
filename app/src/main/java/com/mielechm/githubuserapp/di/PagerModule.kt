package com.mielechm.githubuserapp.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mielechm.githubuserapp.data.model.GitHubDatabase
import com.mielechm.githubuserapp.data.model.GitHubUserRemoteMediator
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.network.ApiService
import org.koin.dsl.module

val pagerModule = module {
    single { providePager(get(), get()) }
}

@OptIn(ExperimentalPagingApi::class)
fun providePager(apiService: ApiService, database: GitHubDatabase): Pager<Int, GitHubUserEntity> =
    Pager(
        config = PagingConfig(pageSize = 25),
        remoteMediator = GitHubUserRemoteMediator(database, apiService),
        pagingSourceFactory = { database.gitHubDao().pagingSource() }
    )