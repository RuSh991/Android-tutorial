package com.example

import android.app.Application
import com.example.new1.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
@HiltAndroidApp

class ExampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}