package com.example.ktorkmm.android

import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitDataModel {
    suspend fun get_json(): KotlinCyberList {
        return Retrofit
            .Builder()
            .baseUrl("https://cyberpunk-data-host.vercel.app")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(KotlinCyberWorkApi::class.java)
            .get_cyberpunk_data()
            .awaitResponse()
            .body()!!;
    }
}
