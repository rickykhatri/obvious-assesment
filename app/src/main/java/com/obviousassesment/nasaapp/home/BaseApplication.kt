package com.obviousassesment.nasaapp.home

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.obviousassesment.nasaapp.home.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * BaseApplication for initialization of app
 */
class BaseApplication : Application() {

    init {
        INSTANCE = this
    }

    companion object {
        private lateinit var INSTANCE: BaseApplication

        val applicationContext: Context
            get() {
                return INSTANCE.applicationContext
            }
    }

    override fun onCreate() {
        super.onCreate()

        setOrientation()

        startKoin {
            // Use Koin Android Logger
            androidLogger(level = org.koin.core.logger.Level.NONE)
            // declare Android context
            androidContext(this@BaseApplication)
            // declare modules to use
            modules(applicationModules)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    /**
     * To lock the orientation of the app to Portrait
     */
    private fun setOrientation() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            @SuppressLint("SourceLockedOrientationActivity")
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {}
        })
    }
}
