package com.mert.kotlincoroutinesmy.dependencyinjection

import com.mert.kotlincoroutinesmy.repository.post.IPostService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Mert Tuncbilek on 2020-01-13.
 */

@Module
object NetworkModule {

    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostsApi(retrofit: Retrofit): IPostService {
        return retrofit.create(IPostService::class.java)
    }

    @Reusable
    @Provides
    @JvmStatic
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}