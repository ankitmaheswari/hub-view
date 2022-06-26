package com.android.hubview.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.hubview.data.PullRequest
import com.android.hubview.repository.PullRequestRepository
import com.android.hubview.utils.Config
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
class PullRequestsViewModel @Inject constructor(
        private val pullRequestRepository: PullRequestRepository) : ViewModel() {

    private val _closedPullRequests:MutableLiveData<List<PullRequest>> = MutableLiveData()
    val closedPullRequest: LiveData<List<PullRequest>>
    get() = pullRequestRepository.closedPullRequests

    init {
        fetchClosedPullRequests()
    }

    fun fetchClosedPullRequests() {
        viewModelScope.launch {
            pullRequestRepository.getClosedPullRequests(Config.REPOSITORY_OWNER,
                    Config.REPOSITORY_NAME,
                    Config.DEFAULT_PAGE_NUMBER,
                    Config.PER_PAGE_SIZE
            )
        }
    }
}