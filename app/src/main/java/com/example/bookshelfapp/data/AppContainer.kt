package com.example.bookshelfapp.data

import com.example.bookshelfapp.network.BookApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bookRepository : BookRepository
}
class DefaultAppContainer : AppContainer{

    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val json = Json {ignoreUnknownKeys = true}

    private val retrofit =  Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val bookService : BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }

    override val bookRepository: BookRepository by lazy {
        DefaultBookRepository(bookService)
    }

}