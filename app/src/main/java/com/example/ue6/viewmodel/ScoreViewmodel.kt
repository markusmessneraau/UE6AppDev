package com.example.ue6.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScoreViewModel : ViewModel() {

    private val _teamAScore = MutableStateFlow(0) // darf verändert werden
    val teamAScore: StateFlow<Int> = _teamAScore        //// öffentlich, aber nur lesbar

    private val _teamBScore = MutableStateFlow(0)
    val teamBScore: StateFlow<Int> = _teamBScore

    fun increaseTeamAScore() {
        _teamAScore.value++
    }

    fun increaseTeamBScore() {
        _teamBScore.value++
    }

    fun resetScores() {
        _teamAScore.value = 0
        _teamBScore.value = 0
    }
}
