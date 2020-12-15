package com.example.android_animation_poc.data.api

import com.example.android_animation_poc.data.entity.Media
import retrofit2.Call
import retrofit2.http.GET

interface TrendingService {

    @GET()
    fun fetchTrending(): Call<List<Media>>

}