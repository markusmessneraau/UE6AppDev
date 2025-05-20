package com.example.ue6.repository

import com.example.ue6.model.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MessageRepository {

    fun messageStream(): Flow<Message> = flow {
        var count = 1
        while (true) {
            emit(Message("Nachricht #$count", System.currentTimeMillis()))
            count++
            delay(3000L) // alle 3 Sekunden neue Nachricht
        }
    }
}
