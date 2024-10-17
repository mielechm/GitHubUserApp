package com.mielechm.githubuserapp.di

import com.mielechm.githubuserapp.ui.screens.userdetails.UserDetailsViewModel
import com.mielechm.githubuserapp.ui.screens.userslist.UsersListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val usersListViewModelModule = module { viewModel { UsersListViewModel(get()) } }

val userDetailsViewModelModule = module { viewModel { UserDetailsViewModel(get(), get()) } }