package com.android.hubview.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.hubview.data.PullRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
@Singleton
class PullRequestRepository @Inject constructor(private val pullRequestsApi: PullRequestsApi) {

    private val _closedPullRequests: MutableLiveData<List<PullRequest>> = MutableLiveData<List<PullRequest>>()
    val closedPullRequests: LiveData<List<PullRequest>>
    get() = _closedPullRequests

    suspend fun getClosedPullRequests(repoOwner: String,
                                      repo: String,
                                      nextPage: Int,
                                      itemsPerPage: Int) {
        withContext(Dispatchers.IO) {
            val result = pullRequestsApi.getClosedPullRequests(repoOwner, repo, nextPage, itemsPerPage)
            if (result.isSuccessful && result.body() != null) {
                _closedPullRequests.postValue(result.body())
            }
        }
    }
}