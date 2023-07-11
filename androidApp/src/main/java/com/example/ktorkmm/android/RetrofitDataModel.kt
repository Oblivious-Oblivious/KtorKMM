package com.example.ktorkmm.android;

import com.example.ktorkmm.CyberList;
import com.example.ktorkmm.CyberWork;
import retrofit2.Retrofit;
import retrofit2.awaitResponse;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitDataModel {
    val library = "Retrofit";

    suspend fun getJson(): CyberList =
        try {
            Retrofit
                .Builder()
                .baseUrl("https://cyberpunk-data-host.dreamnotexpiring.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CyberWorkApi::class.java)
                .getCyberpunkData()
                .awaitResponse()
                .body()!!;
        }
        catch(e: Exception) {
            val err = e.localizedMessage ?: "error";
            CyberList(listOf(CyberWork(err, err, err)));
        }
}
