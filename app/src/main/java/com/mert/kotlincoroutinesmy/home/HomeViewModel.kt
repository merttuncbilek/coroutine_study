package com.mert.kotlincoroutinesmy.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mert.kotlincoroutinesmy.manager.HomeManager
import javax.inject.Inject

/**
 * Created by Mert Tuncbilek on 2019-12-13.
 */
abstract class IHomeViewModel: ViewModel() {
    abstract fun actionList(): LiveData<List<String>>
}
class HomeViewModel @Inject constructor(val homeManager: HomeManager): IHomeViewModel() {

    private val _actionList by lazy {
        return@lazy homeManager.getResponse()
    }

    override fun actionList(): LiveData<List<String>> = _actionList

}