package com.mert.kotlincoroutinesmy.manager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mert.kotlincoroutinesmy.data.PostItem
import com.mert.kotlincoroutinesmy.repository.post.PostRepository
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
class PostsManager @Inject constructor(val postRepository: PostRepository) {

    suspend fun getPosts(): MutableLiveData<List<PostItem>> {
        Log.d("THREAD_NAME", Thread.currentThread().name)
        return MutableLiveData(postRepository.getPosts())
    }

}