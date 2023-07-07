package com.example.ktorkmm

import kotlinx.serialization.json.*;

// NOTE LSP understands if dependencies exists or not.
import io.ktor.client.*;
import io.ktor.client.request.*;
import io.ktor.client.statement.*;

class JsonGetter {
    suspend fun get_json(): CyberList {
        val response = HttpClient().get("https://lively-ganache-1b6917.netlify.app/cyberpunk.json");
        return Json.decodeFromString<CyberList>(response.bodyAsText());
    }
}