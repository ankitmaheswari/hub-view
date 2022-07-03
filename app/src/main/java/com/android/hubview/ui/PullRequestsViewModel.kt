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

    val project: String = "${Config.REPOSITORY_OWNER}/${Config.REPOSITORY_NAME}"
    val pageSize = Config.PER_PAGE_SIZE
    val closedPullRequest: LiveData<List<PullRequest>>
        get() = pullRequestRepository.closedPullRequests
    private var isLastPage = false
    private var currentPageNumber = 1
    private var _showProgressBar = MutableLiveData(true)
    val isLoading: LiveData<Boolean>
        get() = _showProgressBar


    init {
        fetchClosedPullRequests()
    }

    fun isLastPage(): Boolean {
        return currentPageNumber == Config.MAX_PAGES
    }

    fun loadMoreItems() {
        currentPageNumber += 1
        fetchClosedPullRequests()
    }

    private fun fetchClosedPullRequests() {
        _showProgressBar.postValue(true)
        viewModelScope.launch {
            pullRequestRepository.getClosedPullRequests(Config.REPOSITORY_OWNER,
                    Config.REPOSITORY_NAME,
                    currentPageNumber,
                    Config.PER_PAGE_SIZE
            )
            _showProgressBar.postValue(false)
        }
    }
}