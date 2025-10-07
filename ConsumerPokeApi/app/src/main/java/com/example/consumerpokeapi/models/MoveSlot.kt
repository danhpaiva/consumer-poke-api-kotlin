package com.example.consumerpokeapi.models

data class MoveSlot(
    val move: NamedApiResource,
    val version_group_details: List<VersionGroupDetail>
)
