package com.example.ktorkmm;

import kotlinx.serialization.json.Json;

// NOTE LSP understands if dependencies exists or not.
import io.ktor.client.*;
import io.ktor.client.request.*;
import io.ktor.client.statement.*;

class KMMCommonKtorJsonGetter {
    suspend fun getJson(): CyberList =
        Json
            .decodeFromString(
                HttpClient()
                    .get("https://cyberpunk-data-host.dreamnotexpiring.com/")
                    .bodyAsText()
            );
}
