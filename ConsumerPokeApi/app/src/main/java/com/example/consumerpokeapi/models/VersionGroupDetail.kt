package com.example.consumerpokeapi.models

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: NamedApiResource,
    val order: Int?,
    val version_group: NamedApiResource
)
