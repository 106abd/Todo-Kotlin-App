package com.example.todoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDAO {

    @Query("SELECT * FROM TODO ORDER BY creationDate DESC")
    fun getAllTodos() : Flow<List<Todo>>

    @Insert
    suspend fun addTodo(todo: Todo)

    @Query("DELETE FROM TODO WHERE id = :id")
    suspend fun deleteTodo(id: Int)

}