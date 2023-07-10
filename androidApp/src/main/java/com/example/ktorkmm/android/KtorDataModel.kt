package com.example.ktorkmm.android

import com.example.ktorkmm.CyberList
import com.example.ktorkmm.CyberWork
import com.example.ktorkmm.KMMCommonKtorJsonGetter

class KtorDataModel {
    val library = "Ktor";

    suspend fun getJson(): CyberList {
        return try {
            KMMCommonKtorJsonGetter().getJson();
        }
        catch(e: Exception) {
            val err = e.localizedMessage ?: "error";
            CyberList(listOf(CyberWork(err, err, err)));
        }
    }
}
