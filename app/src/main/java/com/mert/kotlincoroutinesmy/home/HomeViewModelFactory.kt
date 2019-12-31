package com.mert.kotlincoroutinesmy.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mert.kotlincoroutinesmy.manager.HomeManager
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
class HomeViewModelFactory @Inject constructor(private val homeManager: HomeManager): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(homeManager = homeManager) as T
    }
}