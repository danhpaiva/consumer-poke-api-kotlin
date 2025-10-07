package com.example.consumerpokeapi.models

data class AbilitySlot(
    val ability: NamedApiResource,
    val is_hidden: Boolean,
    val slot: Int
)
