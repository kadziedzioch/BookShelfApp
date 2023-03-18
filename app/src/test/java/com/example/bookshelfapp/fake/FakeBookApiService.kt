package com.example.bookshelfapp.fake

import com.example.bookshelfapp.network.*

class FakeBookApiService :BookApiService{
    override suspend fun getBooks(): Response {
        return FakeDataSource.response
    }

    override suspend fun getBook(id: String): Book {
        var b = Book("", VolumeInfo("", ImageLink("")))
       for(book in FakeDataSource.response.items){
           if(book.id == id){
               b = book
           }
       }
        return b
    }
}