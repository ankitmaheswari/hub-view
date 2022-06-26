package com.android.hubview.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.hubview.ui.PullRequestsViewModel
import com.android.hubview.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PullRequestsViewModel::class)
    abstract fun bindPullRequestsViewModel(pullRequestsViewModel: PullRequestsViewModel): ViewModel
}