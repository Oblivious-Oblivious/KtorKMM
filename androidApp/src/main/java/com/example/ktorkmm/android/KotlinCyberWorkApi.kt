package com.example.ktorkmm.android

import retrofit2.Call
import retrofit2.http.GET

interface KotlinCyberWorkApi {
    @GET("cyberpunk")
    fun get_cyberpunk_data(): Call<KotlinCyberList>;
}