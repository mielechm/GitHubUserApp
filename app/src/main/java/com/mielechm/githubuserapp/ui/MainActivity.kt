package com.mielechm.githubuserapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.mielechm.githubuserapp.ui.navigation.DetailsScreen
import com.mielechm.githubuserapp.ui.navigation.ListScreen
import com.mielechm.githubuserapp.ui.screens.userdetails.UserDetailsScreen
import com.mielechm.githubuserapp.ui.screens.userdetails.UserDetailsViewModel
import com.mielechm.githubuserapp.ui.screens.userslist.UsersListScreen
import com.mielechm.githubuserapp.ui.screens.userslist.UsersListViewModel
import com.mielechm.githubuserapp.ui.theme.GitHubUserAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubUserAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = ListScreen) {
                    composable<ListScreen> {
                        val viewModel: UsersListViewModel by viewModel()
                        val users = viewModel.userPagingFlow.collectAsLazyPagingItems()
                        UsersListScreen(navController = navController, gitHubUsers = users)
                    }
                    composable<DetailsScreen> {
                        val viewModel: UserDetailsViewModel by viewModel()
                        val userDetails = viewModel.userDetails.collectAsStateWithLifecycle()
                        UserDetailsScreen(
                            navController = navController,
                            userDetails = userDetails.value
                        )
                    }
                }
            }
        }
    }
}
