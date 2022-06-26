package com.android.hubview

import android.app.Application
import com.android.hubview.di.ApplicationComponent
import com.android.hubview.di.DaggerApplicationComponent

/**
 * Created by Ankit Maheswari on 25/06/22.
 */
class HubApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}