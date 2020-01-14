package com.mert.kotlincoroutinesmy.repository.post

import javax.inject.Inject

//
// Created by Ekrem Hatipoglu on 2019-12-31.
// Copyright (c) 2019 Evrensel. All rights reserved.
//
class PostRepository @Inject constructor(val postApi: IPostService) {
    suspend fun getPosts() = postApi.getPosts()
}