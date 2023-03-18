package com.example.bookshelfapp.fake

import com.example.bookshelfapp.data.DefaultBookRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class BookRepositoryTest {

    @Test
    fun bookRepository_getBooks_verifyBookList() =
        runTest {
            val repository = DefaultBookRepository(
                bookApiService = FakeBookApiService()
            )
            assertEquals(FakeDataSource.response, repository.getBooks())
        }

    @Test
    fun bookRepository_getBook_verifyBook() =
        runTest {
            val repository = DefaultBookRepository(
                bookApiService = FakeBookApiService()
            )
            assertEquals(FakeDataSource.response.items[0],repository.getBook("djd"))
        }

}