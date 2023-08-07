package com.example.jetpackloading

import CircularPulsatingIndicator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ui.theme.JetpackLoadingTheme
import com.example.jetpackloading.ui.theme.background
import com.example.jetpackloading.ui.theme.loading_component.GridPulsatingDot
import com.example.jetpackloading.ui.theme.loading_component.PulsatingDot

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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(40.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        PulsatingDot(color = Color.White)

        Spacer(modifier = Modifier.width(50.dp))

        GridPulsatingDot(color = Color.White, rowCount = 3, colCount = 3)

        Spacer(modifier = Modifier.width(50.dp))

        CircularPulsatingIndicator(color = Color.White)
    }

    Spacer(modifier = Modifier.height(20.dp))

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackLoadingTheme {
        Greeting("Android")
    }
}