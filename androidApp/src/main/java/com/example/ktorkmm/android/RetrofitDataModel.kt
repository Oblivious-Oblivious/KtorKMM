package com.example.ktorkmm.android

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitDataModel {
    fun get_json(): KotlinCyberList {
        val v1 = Retrofit.Builder();
        val v2 = v1.baseUrl("https://lively-ganache-1b6917.netlify.app/")
        val v3 = v2.addConverterFactory(JacksonConverterFactory.create());
        val v4 = v3.build();
        val v5 = v4.create(KotlinCyberWorkApi::class.java);
        val v6 = v5.get_cyberpunk_data();
        val v7 = v6.execute();
//        val v8 = v7.body()!!;

        return KotlinCyberList(listOf(KotlinCyberWork("ok", "ok", "ok")));
    }
}
