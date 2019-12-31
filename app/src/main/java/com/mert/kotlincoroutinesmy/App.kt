package com.mert.kotlincoroutinesmy

import android.app.Activity
import android.app.Application
import com.mert.kotlincoroutinesmy.dependencyinjection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by Mert Tuncbilek on 2019-12-14.
 */
class App: Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}