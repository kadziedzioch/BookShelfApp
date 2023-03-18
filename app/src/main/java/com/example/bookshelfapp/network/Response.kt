package com.example.bookshelfapp.network

import kotlinx.serialization.Serializable


@Serializable
data class Response(
    val items: List<Book>
)
