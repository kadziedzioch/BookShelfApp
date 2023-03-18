package com.example.bookshelfapp.network

import retrofit2.http.GET
import retrofit2.http.Path

interface BookApiService {

    @GET("volumes?q=clare")
    suspend fun getBooks() : Response

    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id:String): Book

}