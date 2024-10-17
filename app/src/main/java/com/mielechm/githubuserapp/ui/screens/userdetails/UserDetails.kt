package com.mielechm.githubuserapp.ui.screens.userdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.mielechm.githubuserapp.data.model.model.UserDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(navController: NavController, userDetails: UserDetails) {

    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("login") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                )
            }
        ) { padding ->
            UserDetailsContent(userDetails, padding)
        }
    }
}

@Composable
fun UserDetailsContent(userDetails: UserDetails, paddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Row {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }, model = userDetails.avatar, contentDescription = "${userDetails.login} avatar"
            )
            Column(modifier= Modifier
                .weight(1f)
                .padding(8.dp)) {
                    Text(text = "Name: ${userDetails.name}")
                    Text(text = "Company: ${userDetails.company}")
                    Text(text = "Location: ${userDetails.location}")
                Text(text = "Followers: ${userDetails.followers}")
            }
        }
        Row {
            Text(text = "Bio: ${userDetails.bio}")
        }
    }
}