package com.example.ue6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ue6.viewmodel.ScoreViewModel

@Composable
fun ScoreboardScreen() {

    val viewModel: ScoreViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

    val teamAScore by viewModel.teamAScore.collectAsState()
    val teamBScore by viewModel.teamBScore.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Team A: $teamAScore", style = MaterialTheme.typography.headlineMedium)
        Text("Team B: $teamBScore", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Button(onClick = { viewModel.increaseTeamAScore() }) {
                Text("Team A +1")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.increaseTeamBScore() }) {
                Text("Team B +1")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.resetScores() }) {
            Text("Reset")
        }
    }
}
