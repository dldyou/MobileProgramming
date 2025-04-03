package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var toggled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            Text(text = "미완료 항목만 보기")
            Spacer(modifier = Modifier.padding(4.dp))
            TodoSwitch(toggled) { isChecked ->
                toggled = isChecked
            }
        }

        todoList.forEachIndexed { index, item ->
            if (!toggled || item.status == TodoStatus.PENDING) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row {
                        TodoCheckbox(item.status == TodoStatus.COMPLETED) { isChecked ->
                            todoList[index] = item.copy(
                                status = if (isChecked) TodoStatus.COMPLETED
                                else TodoStatus.PENDING
                            )
                        }
                        TodoItem(item = item)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList())
}