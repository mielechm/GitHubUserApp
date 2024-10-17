package com.mielechm.githubuserapp.di

import org.koin.dsl.module

val appModule = module {
    includes(
        usersListViewModelModule,
        userDetailsViewModelModule,
        repositoryModule,
        networkModule,
        databaseModule,
        pagerModule
    )
}