package com.android.hubview.di.modules

import dagger.Module

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
@Module(includes = [ViewModelModule::class,
    NetworkModule::class,
    DataModule::class])
class ApplicationModule