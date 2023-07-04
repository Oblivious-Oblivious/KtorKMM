package com.example.ktorkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform