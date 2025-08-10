package com.example.todoapp.db

import androidx.room.TypeConverter
import java.util.Date

// Class that converts data types that are uncompatible with SQLite
class Converters {

    @TypeConverter
    fun fromDate(date: Date) : Long {
        return date.time
    }

    @TypeConverter
    fun toDate(time: Long) : Date {
        return Date(time)
    }

}