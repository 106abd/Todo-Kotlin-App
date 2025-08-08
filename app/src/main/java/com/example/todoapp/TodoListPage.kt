package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TodoListPage(modifier: Modifier = Modifier) {

    val todoList = getDebugTodo()

    Column (
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        LazyColumn(){
            itemsIndexed(todoList) { index: Int, todoItem: Todo ->
                TodoItem(todoItem = todoItem)
            }
        }
    }
}

@Composable
fun TodoItem(modifier: Modifier = Modifier, todoItem: Todo) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Column {
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
    }
}
