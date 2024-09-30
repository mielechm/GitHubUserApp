package com.mielechm.githubuserapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubUserApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GitHubUserApplication)
            modules()
        }
    }
}