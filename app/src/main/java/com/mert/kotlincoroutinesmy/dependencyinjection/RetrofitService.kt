package com.mert.kotlincoroutinesmy.dependencyinjection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//
// Created by Ekrem Hatipoglu on 2019-12-31.
// Copyright (c) 2019 Evrensel. All rights reserved.
//

class RetrofitService {
    companion object {
        var instance: Retrofit? = null
        fun getRetrofit(): Retrofit {
            if (instance == null)
                instance = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .client(OkHttpClient().newBuilder().build())
                    .build()
            return instance!!
        }

        inline fun <reified T> createService(): T {
            return getRetrofit().create(T::class.java)
        }
    }
}