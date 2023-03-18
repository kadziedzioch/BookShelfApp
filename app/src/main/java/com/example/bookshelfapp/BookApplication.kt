package com.example.bookshelfapp

import android.app.Application
import com.example.bookshelfapp.data.AppContainer
import com.example.bookshelfapp.data.DefaultAppContainer

class BookApplication : Application() {

    lateinit var appContainer : AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer =  DefaultAppContainer()
    }
}