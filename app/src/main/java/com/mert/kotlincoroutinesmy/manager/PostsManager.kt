package com.mert.kotlincoroutinesmy.manager

import androidx.lifecycle.MutableLiveData
import com.mert.kotlincoroutinesmy.data.PostItem
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
class PostsManager @Inject constructor() {

    fun getPosts(): MutableLiveData<List<PostItem>> {

        val postItem1 = PostItem(1,1, "title1", "body1")
        val postItem2 = PostItem(2,2, "title2", "body2")

        return MutableLiveData(listOf(postItem1, postItem2))
    }

    fun getPost(id: Int): MutableLiveData<PostItem> {
        val postItem1 = PostItem(1,1, "title1", "body1")
        return MutableLiveData(postItem1)
    }

}