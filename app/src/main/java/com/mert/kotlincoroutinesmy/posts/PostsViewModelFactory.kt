package com.mert.kotlincoroutinesmy.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mert.kotlincoroutinesmy.manager.PostsManager
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
class PostsViewModelFactory @Inject constructor(val manager: PostsManager): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(manager) as T
    }
}