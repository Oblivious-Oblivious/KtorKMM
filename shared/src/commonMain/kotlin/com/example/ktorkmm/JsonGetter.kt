package com.example.ktorkmm

import kotlinx.serialization.json.*;

// NOTE LSP understands if dependencies exists or not.
import io.ktor.client.*;
import io.ktor.client.request.*;
import io.ktor.client.statement.*;

class JsonGetter {
    suspend fun get_json(): CyberList {
        return Json
            .decodeFromString(
                HttpClient()
                    .get("https://cyberpunk-data-host.dreamnotexpiring.com/")
                    .bodyAsText()
            );
    }
}