package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val todoListPageViewModel = ViewModelProvider(this)[TodoListPageViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    TodoListPage(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = todoListPageViewModel
                    )
                }
            }
        }
    }
}
