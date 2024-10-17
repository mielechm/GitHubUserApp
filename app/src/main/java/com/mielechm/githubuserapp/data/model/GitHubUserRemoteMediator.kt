package com.mielechm.githubuserapp.data.model

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil.network.HttpException
import com.mielechm.githubuserapp.data.mappers.toGitHubUserEntity
import com.mielechm.githubuserapp.data.model.entities.GitHubUserEntity
import com.mielechm.githubuserapp.data.model.model.GitHubUser
import com.mielechm.githubuserapp.network.ApiService
import io.ktor.client.call.body
import okio.IOException

@OptIn(ExperimentalPagingApi::class)
class GitHubUserRemoteMediator(
    private val gitHubDatabase: GitHubDatabase,
    private val apiService: ApiService
) : RemoteMediator<Int, GitHubUserEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GitHubUserEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        0
                    } else {
                        lastItem.id + 1
                    }
                }
            }
            val users = apiService.getUsers(since = loadKey, perPage = state.config.pageSize).body<List<GitHubUser>>()
            gitHubDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    gitHubDatabase.gitHubDao().clearAll()
                }
                val userEntities = users.map {
                    it.toGitHubUserEntity()
                }
                gitHubDatabase.gitHubDao().upsertAll(userEntities)
                MediatorResult.Success(endOfPaginationReached = users.isEmpty())
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}