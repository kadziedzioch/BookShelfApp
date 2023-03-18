package com.example.bookshelfapp.fake

import com.example.bookshelfapp.network.Book
import com.example.bookshelfapp.network.ImageLink
import com.example.bookshelfapp.network.Response
import com.example.bookshelfapp.network.VolumeInfo

object FakeDataSource {
    private val imageLink = ImageLink("img")
    private val volumeInfo = VolumeInfo(title = "title", imageLink)
    private val book1 = Book(id = "djd", volumeInfo)
    private val book2 = Book(id = "fff", volumeInfo)
    private val bookList = listOf<Book>(book1,book2)
    val response = Response(bookList)

}