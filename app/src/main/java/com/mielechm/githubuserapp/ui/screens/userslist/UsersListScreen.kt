package com.mielechm.githubuserapp.ui.screens.userslist

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.SubcomposeAsyncImage
import com.mielechm.githubuserapp.data.model.model.GitHubUser
import com.mielechm.githubuserapp.ui.navigation.DetailsScreen

@SuppressLint("ShowToast")
@Composable
fun UsersListScreen(
    navController: NavController,
    gitHubUsers: LazyPagingItems<GitHubUser>
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = gitHubUsers.loadState) {
        if (gitHubUsers.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error occurred: ${(gitHubUsers.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                if (gitHubUsers.loadState.refresh is LoadState.Loading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(
                            count = gitHubUsers.itemCount,
                            key = gitHubUsers.itemKey { user -> user.id }) { index ->
                            gitHubUsers[index]?.let { UserItem(user = it, navController = navController) }
                        }

                        item {
                            if (gitHubUsers.loadState.append is LoadState.Loading) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserItem(user: GitHubUser, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable {
                navController.navigate(DetailsScreen)
            }) {

            Row(modifier = Modifier.padding(8.dp)) {
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
                    }, model = user.avatar, contentDescription = "${user.login} avatar"
                )
                Text(
                    modifier = Modifier
                        .weight(3f)
                        .padding(8.dp),
                    text = user.login,
                    fontSize = 20.sp
                )
            }
        }
    }
}