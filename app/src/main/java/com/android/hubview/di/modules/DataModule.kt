package com.android.hubview.di.modules

import com.android.hubview.repository.PullRequestRepository
import com.android.hubview.repository.PullRequestsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
@Module(includes = [NetworkModule::class])
class DataModule {

    @Singleton
    @Provides
    fun providesPullRequestRepository(pullRequestsApi: PullRequestsApi): PullRequestRepository {
        return PullRequestRepository(pullRequestsApi)
    }
}