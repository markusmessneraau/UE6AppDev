package com.example.ue6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ue6.ui.NavigationGraph
import com.example.ue6.ui.theme.UE6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UE6Theme {
                NavigationGraph()
            }
        }
    }
}
