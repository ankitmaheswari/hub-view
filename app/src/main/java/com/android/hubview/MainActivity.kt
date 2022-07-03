package com.android.hubview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.hubview.databinding.ActivityMainBinding
import com.android.hubview.ui.PullRequestAdapter
import com.android.hubview.ui.PullRequestsViewModel
import com.android.hubview.utils.Config
import javax.inject.Inject

class MainActivity : AppCompatActivity() {



    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PullRequestsViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as HubApplication).applicationComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@MainActivity
        binding.executePendingBindings()

        supportActionBar?.let {
            title = getString(R.string.toolbar_title_pull_requests)
        }

        val pullRequestAdapter = PullRequestAdapter(listOf())
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.pullRequestsRv.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(this.context, RecyclerView.VERTICAL))
            adapter = pullRequestAdapter
        }

        viewModel.closedPullRequest.observe(this, Observer {
            pullRequestAdapter.update(it)
        })
    }
}