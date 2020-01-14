package com.mert.kotlincoroutinesmy.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.mert.kotlincoroutinesmy.BaseFragment
import com.mert.kotlincoroutinesmy.R
import com.mert.kotlincoroutinesmy.data.PostItem
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-13.
 */
class PostsFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var postsViewModel: IPostsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postsViewModel = ViewModelProviders.of(this, viewModelFactory).get(IPostsViewModel::class.java)
        postsViewModel.posts.observe(this, postsObserver)

        button_close_posts.setOnClickListener { _ ->
            view.findNavController().popBackStack()
        }

        postsViewModel.getPostListFromService()
    }

    private val postsObserver = Observer<List<PostItem>> { posts ->
        Log.d("POST_1", "${posts.size}")
    }

}