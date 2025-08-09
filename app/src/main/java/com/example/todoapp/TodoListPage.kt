package com.example.todoapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TodoListPage(modifier: Modifier = Modifier, viewModel: TodoListPageViewModel) {

    val todoList = viewModel.todoList
    val inputText by viewModel.inputText

    Column (
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                modifier = Modifier.padding(end = 10.dp).weight(1f),
                value = inputText,
                onValueChange = {textInput -> viewModel.onTextChange(textInput)}
            )

            FloatingActionButton(
                onClick = { viewModel.addTodo(inputText)}
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_add_24),
                    contentDescription = "Add"
                )
            }
        }

        if (todoList.isNotEmpty()) {
            // List Rendering
            LazyColumn(content = {
                itemsIndexed(todoList.reversed()) { index: Int, todoItem: Todo ->
                    TodoItem(todoItem = todoItem, onDelete = {
                        viewModel.deleteTodo(id = todoItem.id)
                    })
                }
            })
        } else {
            Text(
                text = "No items yet.",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

// Composable for the formatting of each individual todo item
@Composable
fun TodoItem(modifier: Modifier = Modifier, todoItem: Todo, onDelete : () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {
        // Todo Text Data
        Column (modifier = Modifier.weight(1f)){
            // Date
            Text(
                text = SimpleDateFormat("hh:mm a, dd/MM/yy", Locale.CANADA).format(todoItem.creationDate),
                fontSize = 12.sp,
                color = Color.Magenta,
            )

            // Message
            Text(
                text = todoItem.title,
                fontSize = 18.sp,
                color = Color.DarkGray
                )
        }

        IconButton(
            onClick = { onDelete() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.Black
            )
        }
    }
}
