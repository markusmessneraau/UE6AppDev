package com.example.ue6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ue6.model.Message
import com.example.ue6.repository.MessageRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {

    private val repository = MessageRepository()

    private val _currentMessage = MutableStateFlow<Message?>(null)
    val currentMessage: StateFlow<Message?> = _currentMessage

    private var streamJob: Job? = null

    fun startStream() {
        if (streamJob?.isActive != true) {
            streamJob = viewModelScope.launch {
                repository.messageStream().collect {
                    _currentMessage.value = it
                }
            }
        }
    }

    fun stopStream() {
        streamJob?.cancel()
        streamJob = null
    }

    fun toggleStream() {
        if (streamJob?.isActive == true) {
            stopStream()
        } else {
            startStream()
        }
    }
}
