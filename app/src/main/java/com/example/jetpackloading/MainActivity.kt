package com.example.jetpackloading

import CircularPulsatingIndicator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ui.theme.JetpackLoadingTheme
import com.example.jetpackloading.ui.theme.background
import com.example.jetpackloading.ui.theme.loading_component.GridPulsatingDot
import com.example.jetpackloading.ui.theme.loading_component.PulsatingDot
import com.example.jetpackloading.ui.theme.loading_component.SquareSpinIndicator

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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(background)
                            .padding(vertical = 40.dp, horizontal = 10.dp)
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Row(
        modifier = Modifier.size(width = rowWidth, height = rowHeight),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PulsatingDot()
        GridPulsatingDot()
        CircularPulsatingIndicator()
    }

    Spacer(modifier = Modifier.height(100.dp))

    Row(
        modifier = Modifier.size(width = rowWidth, height = rowHeight),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SquareSpinIndicator()
    }
}