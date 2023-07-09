package com.example.ktorkmm.android

import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitDataModel {
    val library = "Retrofit";

    suspend fun get_json(): KotlinCyberList {
        return try {
            Retrofit
                .Builder()
                .baseUrl("https://cyberpunk-data-host.dreamnotexpiring.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(KotlinCyberWorkApi::class.java)
                .get_cyberpunk_data()
                .awaitResponse()
                .body()!!;
        }
        catch(e: Exception) {
            val err = e.localizedMessage ?: "error";
            KotlinCyberList(listOf(KotlinCyberWork(err, err, err)));
        }
    }
}
