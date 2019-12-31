package com.mert.kotlincoroutinesmy.posts

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
@Module
abstract class PostsModule {

    @Binds
    abstract fun bindPostsViewModelFactory(postsViewModelFactory: PostsViewModelFactory): ViewModelProvider.Factory
}