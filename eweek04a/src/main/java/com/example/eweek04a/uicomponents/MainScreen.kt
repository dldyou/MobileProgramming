package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember { TodoItemFactory.makeTodoList() }
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        TodoListTitle()
        Spacer(modifier = Modifier.height(8.dp))
        TodoList(todoList, modifier = Modifier.weight(1.0f))
        Spacer(modifier = Modifier.height(8.dp))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}