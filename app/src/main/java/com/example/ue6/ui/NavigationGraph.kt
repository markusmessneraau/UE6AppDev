package com.example.ue6.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ue6.ui.ScoreboardScreen
import com.example.ue6.ui.HomeScreen

object Routes {
    const val HOME = "home"
    const val SCOREBOARD = "scoreboard"
    const val TODO = "todo"
}

@Composable
fun NavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(navController)
        }
        composable(Routes.SCOREBOARD) {
            ScoreboardScreen()
        }

        composable(Routes.TODO) {
            TodoScreen()
        }
    }
}
