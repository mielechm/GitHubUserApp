package com.mielechm.githubuserapp.ui.screens.userslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.mielechm.githubuserapp.data.mappers.toGitHubUser
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import kotlinx.coroutines.flow.map

class UsersListViewModel(
    pager: Pager<Int, GitHubUserEntity>
) : ViewModel() {
    val userPagingFlow = pager.flow.map { pagingData ->
        pagingData.map { it.toGitHubUser() }
    }.cachedIn(viewModelScope)

}