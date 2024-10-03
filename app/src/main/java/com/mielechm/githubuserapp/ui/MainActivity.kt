package com.mielechm.githubuserapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mielechm.githubuserapp.ui.navigation.ListScreen
import com.mielechm.githubuserapp.ui.screens.UsersListScreen
import com.mielechm.githubuserapp.ui.screens.UsersListViewModel
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
                        UsersListScreen(navController = navController, viewModel)
                    }
                }
            }
        }
    }
}
