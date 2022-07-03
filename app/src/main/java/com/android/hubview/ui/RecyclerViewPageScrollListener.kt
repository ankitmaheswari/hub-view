package com.android.hubview.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ankit Maheswari on 03/07/22.
 */
abstract class RecyclerViewPageScrollListener(private val layoutManager: LinearLayoutManager)
    : RecyclerView.OnScrollListener() {

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

        val visibleItems = layoutManager.childCount
        val totalItems = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
        if (!isLastPage() && !isLoading()) {
            if (visibleItems + firstVisibleItem >= totalItems
                && firstVisibleItem >= 0
                && totalItems >= pageSize()) {
                loadMoreItems()
            }
        }
    }

    abstract fun isLoading(): Boolean

    abstract fun isLastPage(): Boolean

    abstract fun loadMoreItems()

    abstract fun pageSize(): Int
}