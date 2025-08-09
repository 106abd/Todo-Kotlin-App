package com.example.todoapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TodoListPageViewModel : ViewModel() {

    private val _inputText = mutableStateOf("")
    val inputText : State<String> get() = _inputText

    fun onTextChange(newText : String) {
        _inputText.value = newText
    }
}