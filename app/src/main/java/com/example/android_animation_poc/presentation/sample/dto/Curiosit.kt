package com.example.android_animation_poc.presentation.sample.dto

import java.io.Serializable

data class Curiosity(
    val wasPrincipal: Boolean,
    val image: String,
    val title: String,
    val images: List<String>,
    val body: List<String>
) : Serializable