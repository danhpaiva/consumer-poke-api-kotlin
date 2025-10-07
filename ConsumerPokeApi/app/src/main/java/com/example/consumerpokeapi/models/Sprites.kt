package com.example.consumerpokeapi.models

data class Sprites(
    val back_default: String?,
    val back_female: String?, // Nullable
    val back_shiny: String?,
    val back_shiny_female: String?, // Nullable
    val front_default: String?,
    val front_female: String?, // Nullable
    val front_shiny: String?,
    val front_shiny_female: String?, // Nullable
    val other: OtherSprites,
    val versions: Versions
)
