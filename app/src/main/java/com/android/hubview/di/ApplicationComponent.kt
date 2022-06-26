package com.android.hubview.di

import android.content.Context
import com.android.hubview.di.modules.ApplicationModule
import com.android.hubview.di.modules.DataModule
import com.android.hubview.di.modules.NetworkModule
import com.android.hubview.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import com.android.hubview.MainActivity
import dagger.android.AndroidInjectionModule

/**
 * Created by Ankit Maheswari on 25/06/22.
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ApplicationModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DataModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}