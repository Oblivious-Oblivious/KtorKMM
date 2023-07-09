package com.example.ktorkmm.android

import com.example.ktorkmm.CyberList
import com.example.ktorkmm.CyberWork
import com.example.ktorkmm.JsonGetter

class KtorDataModel {
    val library = "Ktor";

    suspend fun get_json(): CyberList {
        return try {
            JsonGetter().get_json();
        }
        catch(e: Exception) {
            val err = e.localizedMessage ?: "error";
            CyberList(listOf(CyberWork(err, err, err)));
        }
    }
}
