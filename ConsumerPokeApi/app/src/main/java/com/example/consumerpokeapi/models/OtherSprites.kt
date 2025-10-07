package com.example.consumerpokeapi.models

import com.google.gson.annotations.SerializedName

data class OtherSprites(
    val dream_world: DreamWorld,
    val home: Home,
    // ⚠️ CORREÇÃO: Usar @SerializedName para mapear o nome com hífen do JSON
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)
