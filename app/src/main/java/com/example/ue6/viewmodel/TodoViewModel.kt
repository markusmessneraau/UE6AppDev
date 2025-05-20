package com.example.ue6.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ue6.model.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TodoViewModel : ViewModel() {

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos

    private var nextId = 1

    fun addTodo(title: String) {
        val newTodo = Todo(id = nextId++, title = title)
        _todos.value = _todos.value + newTodo
    }

    fun toggleTodoDone(id: Int) {
        _todos.value = _todos.value.map { todo ->   //Lambda-Funktion, for (todo in todos)
            if (todo.id == id) todo.copy(isDone = !todo.isDone) else todo
        }
    }
}
