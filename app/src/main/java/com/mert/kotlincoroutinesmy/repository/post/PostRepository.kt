package com.mert.kotlincoroutinesmy.repository.post

import com.mert.kotlincoroutinesmy.dependencyinjection.RetrofitService

//
// Created by Ekrem Hatipoglu on 2019-12-31.
// Copyright (c) 2019 Evrensel. All rights reserved.
//

class PostRepository {

    val service by lazy {
        RetrofitService.createService<IPostService>()
    }

    suspend fun getPosts() = service.getPosts()
}