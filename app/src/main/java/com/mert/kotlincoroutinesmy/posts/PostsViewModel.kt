package com.mert.kotlincoroutinesmy.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mert.kotlincoroutinesmy.data.PostItem
import com.mert.kotlincoroutinesmy.manager.PostsManager
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

/**
 * Created by Mert Tuncbilek on 2019-12-15.
 */
abstract class IPostsViewModel(): ViewModel() {
    abstract val posts: LiveData<List<PostItem>>
    abstract fun getPostListFromService()
}
class PostsViewModel @Inject constructor(val manager: PostsManager): IPostsViewModel() {


    private var _posts = MutableLiveData<List<PostItem>>()
    override val posts: LiveData<List<PostItem>> by lazy {
        return@lazy _posts
    }

    override fun getPostListFromService() {
        CoroutineScope(Dispatchers.IO).launch {
            val data = manager.getPosts()
            withContext(Dispatchers.Main){
                _posts.value = data.value
            }
        }
    }
    private val _postList by lazy {
        return@lazy MutableLiveData(listOf<PostItem>())
    }

}

private fun <K, V> lazyMap(function: (K) -> V): Map<K, V> {
    val map = mutableMapOf<K, V>()
    return map.withDefault { key ->
        val newValue = function(key)
        map[key] = newValue
        return@withDefault newValue
    }
}

