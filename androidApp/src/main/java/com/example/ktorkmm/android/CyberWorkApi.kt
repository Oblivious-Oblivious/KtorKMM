package com.example.ktorkmm.android

import com.example.ktorkmm.CyberList
import retrofit2.Call
import retrofit2.http.GET

interface CyberWorkApi {
    @GET("/")
    fun get_cyberpunk_data(): Call<CyberList>;
}
