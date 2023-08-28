package com.example.jetpackloading

import CircularPulsatingIndicator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackloading.ui.theme.JetpackLoadingTheme
import com.example.jetpackloading.ui.theme.background
import com.example.jetpackloading.ui.theme.loading_component.BallClipRotatePulseIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallPulseRiseIndicator
import com.example.jetpackloading.ui.theme.loading_component.GridPulsatingDot
import com.example.jetpackloading.ui.theme.loading_component.PacmanIndicator
import com.example.jetpackloading.ui.theme.loading_component.PulsatingDot
import com.example.jetpackloading.ui.theme.loading_component.SemiCircleSpinIndicator
import com.example.jetpackloading.ui.theme.loading_component.SquareSpinIndicator
import com.example.jetpackloading.ui.theme.loading_component.TriangleSpinIndicator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackLoadingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // ------------------ Row #1 ----------------------
        Row(
            modifier = Modifier.size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PulsatingDot()
            GridPulsatingDot()
            CircularPulsatingIndicator()
            BallClipRotatePulseIndicator()
        }

        // ------------------ Row #2 ----------------------
        Row(
            modifier = Modifier.size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SquareSpinIndicator()
            BallPulseRiseIndicator()
        }

        // ------------------ Row #3 ----------------------
        Row(
            modifier = Modifier.size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
        }

        // ------------------ Row #4 ----------------------
        Row(
            modifier = Modifier.size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
        }

        // ------------------ Row #5 ----------------------
        Row(
            modifier = Modifier
                .size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
        }

        // ------------------ Row #6 ----------------------
        Row(
            modifier = Modifier
                .size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
        }

        // ------------------ Row #7 ----------------------
        Row(
            modifier = Modifier.size(width = rowWidth, height = rowHeight),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriangleSpinIndicator()
            PacmanIndicator()
            SemiCircleSpinIndicator()
        }
    }
}