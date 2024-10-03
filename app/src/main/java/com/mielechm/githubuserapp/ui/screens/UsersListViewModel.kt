package com.mielechm.githubuserapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mielechm.githubuserapp.data.model.model.GitHubUser
import com.mielechm.githubuserapp.data.repository.local.LocalRepositoryImpl
import com.mielechm.githubuserapp.data.repository.remote.RemoteRepositoryImpl
import com.mielechm.githubuserapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersListViewModel(
    private val remoteRepositoryImpl: RemoteRepositoryImpl,
    private val localRepositoryImpl: LocalRepositoryImpl
): ViewModel(){

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private val _loadError = MutableStateFlow("")
    val loadError = _loadError.asStateFlow()

    private val _users = MutableStateFlow<List<GitHubUser>>(emptyList())
    val users = _users.asStateFlow()

    fun getGitHubUsers() {
        viewModelScope.launch {
            _isLoading.value = true
            _loadError.value = ""
            when (val result = remoteRepositoryImpl.getUsersPaginated()) {
                is Resource.Error -> {
                    _isLoading.value = false
                    _loadError.value = result.message.toString()
                }
                is Resource.Success -> {
                    _users.value += result.data!!
                    _isLoading.value = false
                    _loadError.value = ""
                }
            }
        }
    }

}