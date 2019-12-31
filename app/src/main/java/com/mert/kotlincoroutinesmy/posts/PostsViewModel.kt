package com.mert.kotlincoroutinesmy.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mert.kotlincoroutinesmy.data.PostItem
import com.mert.kotlincoroutinesmy.manager.PostsManager
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
abstract class IPostsViewModel(): ViewModel() {
    abstract fun getPosts(): LiveData<List<PostItem>>
    abstract fun getPost(id: Int): LiveData<PostItem>
}
class PostsViewModel @Inject constructor(manager: PostsManager): IPostsViewModel() {

    private val _postList by lazy {
        return@lazy manager.getPosts()
    }

    private val _post: Map<Int, LiveData<PostItem>> = lazyMap {id ->
        return@lazyMap manager.getPost(id)
    }

    override fun getPosts(): LiveData<List<PostItem>> = _postList

    override fun getPost(id: Int): LiveData<PostItem> = _post.getValue(id)
}

private fun <K, V> lazyMap(function: (K) -> V): Map<K, V> {
    val map = mutableMapOf<K, V>()
    return map.withDefault { key ->
        val newValue = function(key)
        map[key] = newValue
        return@withDefault newValue
    }
}

