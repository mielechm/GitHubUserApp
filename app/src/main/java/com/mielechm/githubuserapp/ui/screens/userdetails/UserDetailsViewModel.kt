package com.mielechm.githubuserapp.ui.screens.userdetails

import androidx.lifecycle.ViewModel
import com.mielechm.githubuserapp.data.model.model.UserDetails
import com.mielechm.githubuserapp.data.repository.local.LocalRepository
import com.mielechm.githubuserapp.data.repository.remote.RemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserDetailsViewModel(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _userDetails = MutableStateFlow(UserDetails())
    val userDetails = _userDetails.asStateFlow()



}