package com.example.consumerpokeapi.models

data class Generation(
    @get:JvmName("red_blue")
    val red_blue: GameVersionSprite?
)
