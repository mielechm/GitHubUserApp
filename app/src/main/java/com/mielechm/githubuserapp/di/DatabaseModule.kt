package com.mielechm.githubuserapp.di

import android.app.Application
import androidx.room.Room
import com.mielechm.githubuserapp.data.model.GitHubDao
import com.mielechm.githubuserapp.data.model.GitHubDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { provideDao(get()) }
    single { provideDatabase(get()) }
}

fun provideDao(database: GitHubDatabase): GitHubDao = database.gitHubDao()

fun provideDatabase(application: Application): GitHubDatabase =
    Room.databaseBuilder(application, GitHubDatabase::class.java, GitHubDatabase.DATABASE_NAME)
        .fallbackToDestructiveMigration().build()