package com.mielechm.githubuserapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun UsersListScreen(navController: NavController, viewModel: UsersListViewModel) {

    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val loadError by viewModel.loadError.collectAsStateWithLifecycle()
    val users by viewModel.users.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.getGitHubUsers()
    }

    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)) {

                }
        }
    }
}