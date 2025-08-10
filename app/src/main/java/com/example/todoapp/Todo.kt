package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var creationDate: Date
)

// Meant for initial list rendering debugging before add/remove todo logic
fun getDebugTodo () : List<Todo> {
    return listOf<Todo>(
        Todo(1, "First Todo", Date.from(Instant.now())),
        Todo(2, "2nd Todo", Date.from(Instant.now())),
        Todo(3, "Third Todo", Date.from(Instant.now())),
        Todo(4, "4th Todo", Date.from(Instant.now()))
    )
}

