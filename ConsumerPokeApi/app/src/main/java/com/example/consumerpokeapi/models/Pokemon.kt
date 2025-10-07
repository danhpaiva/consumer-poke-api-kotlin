package com.example.consumerpokeapi.models

data class Pokemon(
    val abilities: List<AbilitySlot>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Form>,
    val height: Int,
    val held_items: List<HeldItem>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<MoveSlot>,
    val name: String,
    val species: NamedApiResource,
    val sprites: Sprites,
    val stats: List<StatSlot>,
    val types: List<TypeSlot>,
    val weight: Int
)
