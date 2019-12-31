package com.mert.kotlincoroutinesmy.manager

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-13.
 */
class HomeManager @Inject constructor() {

    fun getResponse(): MutableLiveData<List<String>> {
        val data = MutableLiveData<List<String>>()
        data.value = listOf("Posts", "Topics", "Articles")
        return data
    }

}