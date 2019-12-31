package com.mert.kotlincoroutinesmy.repository.post

import com.mert.kotlincoroutinesmy.data.PostItem
import retrofit2.Call
import retrofit2.http.GET

//
// Created by Ekrem Hatipoglu on 2019-12-31.
// Copyright (c) 2019 Evrensel. All rights reserved.
//

interface IPostService {
    @GET("/posts")
    suspend fun getPosts(): List<PostItem>
}