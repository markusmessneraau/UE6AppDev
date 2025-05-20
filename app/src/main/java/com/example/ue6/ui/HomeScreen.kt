package com.example.ue6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { navController.navigate(Routes.SCOREBOARD) },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("UE1")
            }

            Button(
                onClick = { navController.navigate(Routes.TODO) },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("UE2")
            }
        }
    }
}

