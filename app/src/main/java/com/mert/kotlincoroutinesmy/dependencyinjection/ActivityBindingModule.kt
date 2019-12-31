package com.mert.kotlincoroutinesmy.dependencyinjection

import com.mert.kotlincoroutinesmy.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}