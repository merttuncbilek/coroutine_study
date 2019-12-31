package com.mert.kotlincoroutinesmy.home

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
@Module
abstract class HomeModule {

    @Binds
    abstract fun bindHomeViewModelFactory(homeViewModelFactory: HomeViewModelFactory): ViewModelProvider.Factory

}