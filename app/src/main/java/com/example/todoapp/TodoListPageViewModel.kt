package com.example.todoapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.time.Instant
import java.util.Date

class TodoListPageViewModel : ViewModel() {

    private val _inputText = mutableStateOf("")
    val inputText : State<String> get() = _inputText

    private var _todoList = mutableStateListOf<Todo>()
    val todoList : List<Todo> get() = _todoList


    // Update search bar UI upon text input
    fun onTextChange(newText : String) {
        _inputText.value = newText
    }

    // Add todo item to the list of todos
    fun addTodo(title: String) {

        if (title.isNotBlank()) {

            val todoItem = Todo(
                id = System.currentTimeMillis().toInt(),
                title = title.trimStart().trimEnd(),
                creationDate = Date.from(Instant.now())
            )

            _todoList.add(todoItem)
            _inputText.value = ""
        }
    }

    // Delete a todo given its id
    fun deleteTodo(id: Int) {
        _todoList.removeIf { todo ->
            id == todo.id
        }
    }
}
