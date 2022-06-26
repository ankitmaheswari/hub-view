package com.android.hubview.di.modules

import com.android.hubview.MainActivity
import com.android.hubview.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ankit Maheswari on 26/06/22.
 */
@Module
abstract class ActivityViewModelModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun providesMainActivity(): MainActivity
}