package com.mert.kotlincoroutinesmy.dependencyinjection

import com.mert.kotlincoroutinesmy.home.HomeFragment
import com.mert.kotlincoroutinesmy.home.HomeModule
import com.mert.kotlincoroutinesmy.posts.PostsFragment
import com.mert.kotlincoroutinesmy.posts.PostsModule
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
@Module(includes = [AndroidInjectionModule::class])
abstract class FragmentBindingModule {


    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [PostsModule::class])
    abstract fun bindPostsFragment(): PostsFragment
}