package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.db.TodoDB

// This starts when the application is opened, hence overriding onCreate()
class MainApplication : Application() {

    companion object {
        lateinit var todoDB: TodoDB
    }

    override fun onCreate() {
        super.onCreate()

        todoDB = Room.databaseBuilder(
            applicationContext,
            TodoDB::class.java,
            TodoDB.NAME
        ).build()
    }

}