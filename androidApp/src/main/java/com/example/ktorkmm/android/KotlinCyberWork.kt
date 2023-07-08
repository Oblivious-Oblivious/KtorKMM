package com.example.ktorkmm.android

import com.fasterxml.jackson.annotation.JsonProperty

data class KotlinCyberList(
    @JsonProperty("cyberpunk_works") val cyberpunk_works: List<KotlinCyberWork>
);

data class KotlinCyberWork(
    @JsonProperty("name") val name: String,
    @JsonProperty("creator") val creator: String,
    @JsonProperty("year") val year: String,
);
