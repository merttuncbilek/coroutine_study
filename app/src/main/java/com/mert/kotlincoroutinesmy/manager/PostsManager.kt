package com.mert.kotlincoroutinesmy.manager

import androidx.lifecycle.MutableLiveData
import com.mert.kotlincoroutinesmy.data.PostItem
import com.mert.kotlincoroutinesmy.repository.post.PostRepository
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
class PostsManager @Inject constructor() {

    val postRepository by lazy { PostRepository() }

    suspend fun getPosts(): MutableLiveData<List<PostItem>> {
        return MutableLiveData(postRepository.getPosts())
    }

    fun getPost(id: Int): MutableLiveData<PostItem> {
        val postItem1 = PostItem(1,1, "title1", "body1")
        return MutableLiveData(postItem1)
    }

}