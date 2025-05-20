package com.example.ue6.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.ue6.viewmodel.TodoViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TodoScreen() {

    val viewModel: TodoViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val todos by viewModel.todos.collectAsState()
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Neues Todo") }
        )
        Button(onClick = {
            viewModel.addTodo(text)
            text = ""
        }) {
            Text("Hinzufügen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        todos.forEach { todo ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = todo.isDone,
                    onCheckedChange = { viewModel.toggleTodoDone(todo.id) }
                )
                Text(todo.title)
            }
        }
    }
}
