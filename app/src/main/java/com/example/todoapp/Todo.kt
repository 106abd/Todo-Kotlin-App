package com.example.todoapp

import java.time.Instant
import java.util.Date

data class Todo(
    var id: Int,
    var title: String,
    var creationDate: Date
)

fun getDebugTodo () : List<Todo> {
    return listOf<Todo>(
        Todo(1, "First Todo", Date.from(Instant.now())),
        Todo(2, "2nd Todo", Date.from(Instant.now())),
        Todo(3, "Third Todo", Date.from(Instant.now())),
        Todo(4, "4th Todo", Date.from(Instant.now()))
    )
}

