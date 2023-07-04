package com.example.ktorkmm

import kotlinx.serialization.Serializable;

@Serializable
data class CyberList(val cyberpunk_works: List<CyberWork>);

@Serializable
data class CyberWork(val name: String, val creator: String, val year: String);
