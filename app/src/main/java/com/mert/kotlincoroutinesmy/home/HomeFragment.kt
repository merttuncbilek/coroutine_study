package com.mert.kotlincoroutinesmy.home

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
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-13.
 */
class HomeFragment: BaseFragment() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: IHomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(IHomeViewModel::class.java)

        homeViewModel.actionList().observe(this, Observer { actions ->
            Log.d("ACTIONS", actions.size.toString())
        })

        button_open_posts.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_home_to_posts)
        }
    }

}