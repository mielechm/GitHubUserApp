package com.mielechm.githubuserapp.di

import com.mielechm.githubuserapp.ui.screens.UsersListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module { viewModel { UsersListViewModel(get(), get()) } }