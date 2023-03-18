package com.example.bookshelfapp.network

@kotlinx.serialization.Serializable
data class VolumeInfo(
    val title : String,
    val imageLinks :  ImageLink
)
