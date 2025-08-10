package com.example.todoapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoListPageViewModel : ViewModel() {

    private val todoDao = MainApplication.todoDB.getTodoDAO()

    private val _inputText = mutableStateOf("")
    val inputText : State<String> get() = _inputText

    private var _todoList = mutableStateListOf<Todo>()

    val todoList = todoDao.getAllTodos()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())


    // Update search bar UI upon text input
    fun onTextChange(newText : String) {
        _inputText.value = newText
    }

    // Add todo item to the list of todos
    fun addTodo(title: String) {

        // Do database operation on seperate thread so it doesn't block UI main thread
        viewModelScope.launch(Dispatchers.IO) {
            addItem(title = title)
        }

        _inputText.value = ""
    }

    // Insert todo item into DB entity on separate thread
    suspend fun addItem(title: String) {
        if (title.isNotBlank()) {

            val todoItem = Todo(
                title = title.trimStart().trimEnd(),
                creationDate = Date.from(Instant.now())
            )

            todoDao.addTodo(todo = todoItem)
        }
    }

    // Delete a todo given its id
    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            todoDao.deleteTodo(id = id)
        }
    }
}
