package com.example.ue6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ue6.viewmodel.MessageViewModel

@Composable
fun MessageScreen() {
    val viewModel: MessageViewModel = viewModel()
    val message by viewModel.currentMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = message?.content ?: "Keine Nachricht",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { viewModel.toggleStream() }) {
            Text("Start / Stop")
        }
    }
}
