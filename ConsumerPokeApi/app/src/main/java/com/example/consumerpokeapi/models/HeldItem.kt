package com.example.consumerpokeapi.models

data class HeldItem(
    val item: NamedApiResource,
    val version_details: List<VersionDetail>
)
