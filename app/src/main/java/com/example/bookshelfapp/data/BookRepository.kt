package com.example.bookshelfapp.data

import com.example.bookshelfapp.network.Book
import com.example.bookshelfapp.network.BookApiService
import com.example.bookshelfapp.network.Response

interface BookRepository{
    suspend fun getBooks():Response
    suspend fun getBook(id: String):Book
}

class DefaultBookRepository(
    private val bookApiService: BookApiService
) : BookRepository{

    override suspend fun getBooks(): Response {
        return bookApiService.getBooks()
    }

    override suspend fun getBook(id:String): Book {
        return bookApiService.getBook(id)
    }

}