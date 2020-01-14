package com.mert.kotlincoroutinesmy.dependencyinjection

import android.app.Application
import com.mert.kotlincoroutinesmy.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Mert Tuncbilek on 2019-12-14.
 */
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    NetworkModule::class
])
interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)
}