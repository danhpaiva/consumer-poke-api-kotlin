package com.example.consumerpokeapi.models

data class Versions(
    @get:JvmName("generation_i")
    val generation_i: Generation,
    @get:JvmName("generation_ii")
    val generation_ii: Generation,
)
