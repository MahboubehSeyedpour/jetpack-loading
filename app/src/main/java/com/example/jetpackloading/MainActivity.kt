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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.enums.PunchType
import com.example.jetpackloading.ui.theme.loading_component.lineScaleIndicator.LineScaleIndicator
import com.example.jetpackloading.ui.theme.JetpackLoadingTheme
import com.example.jetpackloading.ui.theme.background
import com.example.jetpackloading.ui.theme.loading_component.BallBeatIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallClipRotateMultipleIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallClipRotatePulseIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallGridBeatIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallPulseRiseIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallPulseSyncIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallRotateIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallScaleIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallScaleMultipleIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallScaleRippleIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallScaleRippleMultipleIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallSpinFadeLoaderIndicator
import com.example.jetpackloading.ui.theme.loading_component.BallZigZagIndicator
import com.example.jetpackloading.ui.theme.loading_component.GridPulsatingDot
import com.example.jetpackloading.ui.theme.loading_component.LineSpinFadeLoaderIndicator
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
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
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
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SquareSpinIndicator()
            BallClipRotateMultipleIndicator()
            BallPulseRiseIndicator()
            BallRotateIndicator()
        }

        // ------------------ Row #3 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallZigZagIndicator()
        }

        // ------------------ Row #4 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallScaleIndicator()
            LineScaleIndicator(punchType = PunchType.ACCORDION_PUNCH)
            LineScaleIndicator(punchType = PunchType.RANDOM_PUNCH)
            BallScaleMultipleIndicator()
        }

        // ------------------ Row #5 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallPulseSyncIndicator()
            BallBeatIndicator()
            LineScaleIndicator(punchType = PunchType.SYMMETRIC_PUNCH)
            LineScaleIndicator(punchType = PunchType.PULSE_OUT_PUNCH)
        }

        // ------------------ Row #6 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallScaleRippleIndicator()
            BallScaleRippleMultipleIndicator()
            BallSpinFadeLoaderIndicator()
            LineSpinFadeLoaderIndicator()
        }

        // ------------------ Row #7 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriangleSpinIndicator()
            PacmanIndicator()
            BallGridBeatIndicator()
            SemiCircleSpinIndicator()
        }
    }
}