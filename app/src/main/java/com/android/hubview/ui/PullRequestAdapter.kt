package com.android.hubview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.android.hubview.R
import com.android.hubview.data.PullRequest
import com.android.hubview.databinding.ListItemPullRequestBinding

/**
 * Created by Ankit Maheswari on 03/07/22.
 */
class PullRequestAdapter(private var pullRequestItems: MutableList<PullRequest>)
    : RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    fun update(updatedPullRequests: List<PullRequest>) {
        pullRequestItems.addAll(updatedPullRequests)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val binding = DataBindingUtil.inflate<ListItemPullRequestBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_pull_request,
            parent,
            false
        )
        return PullRequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        (holder.binding as ListItemPullRequestBinding).apply {
            pullRequest = pullRequestItems[position]
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return pullRequestItems.size
    }

    class PullRequestViewHolder(val binding: ViewBinding): RecyclerView.ViewHolder(binding.root)
}