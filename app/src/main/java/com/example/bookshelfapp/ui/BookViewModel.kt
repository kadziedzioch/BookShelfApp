package com.example.bookshelfapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelfapp.BookApplication
import com.example.bookshelfapp.data.BookRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BookUiState {
    data class Success(val thumbnails: List<String>) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}


class BookViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {

    var bookUiState : BookUiState by mutableStateOf(BookUiState.Loading)
        private set

    init{
        viewModelScope.launch {
            bookUiState = try{
                val books = bookRepository.getBooks()
                val list = mutableListOf<String>()
                for(book in books.items){
                    val thumbnail = bookRepository.getBook(book.id).volumeInfo.imageLinks.thumbnail
                    list.add(thumbnail.replace("http","https"))
                }
                BookUiState.Success(list)
            } catch(ex: IOException) {
                BookUiState.Error
            }
        }
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookApplication)
                val bookRepository = application.appContainer.bookRepository
                BookViewModel(bookRepository)
            }
        }

    }
}