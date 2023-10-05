package com.example.jetpackloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpack_loading.enums.GridAnimationType
import com.example.jetpack_loading.indicators.BallBeatIndicator
import com.example.jetpack_loading.indicators.gridIndicator.GridFadeDiagonal
import com.example.jetpack_loading.indicators.gridIndicator.GridIndicator
import com.example.jetpackloading.enums.PunchType
import com.example.jetpackloading.theme.background
import com.example.jetpackloading.ui.theme.JetpackLoadingTheme
import com.example.jetpackloading.ui.theme.component.lineScaleIndicator.LineScaleIndicator
import com.spr.jetpack_loading.components.BallClipRotateMultipleIndicator
import com.spr.jetpack_loading.components.BallClipRotatePulseIndicator
//import com.example.jetpack_loading.indicators.BallGridBeatIndicator
import com.spr.jetpack_loading.components.BallGridBeatIndicator
import com.spr.jetpack_loading.components.BallPulseRiseIndicator
import com.spr.jetpack_loading.components.BallPulseSyncIndicator
import com.spr.jetpack_loading.components.BallRotateIndicator
import com.spr.jetpack_loading.components.BallScaleIndicator
import com.spr.jetpack_loading.components.BallScaleMultipleIndicator
import com.spr.jetpack_loading.components.BallScaleRippleIndicator
import com.spr.jetpack_loading.components.BallScaleRippleMultipleIndicator
import com.spr.jetpack_loading.components.BallSpinFadeLoaderIndicator
import com.spr.jetpack_loading.components.BallTrianglePathIndicator
import com.spr.jetpack_loading.components.BallZigZagDeflectIndicator
import com.spr.jetpack_loading.components.BallZigZagIndicator
import com.spr.jetpack_loading.components.CircularPulsatingIndicator
import com.spr.jetpack_loading.components.CubeTransitionIndicator
import com.spr.jetpack_loading.components.LineSpinFadeLoaderIndicator
import com.spr.jetpack_loading.components.PacmanIndicator
import com.spr.jetpack_loading.components.PulsatingDot
import com.spr.jetpack_loading.components.SemiCircleSpinIndicator
import com.spr.jetpack_loading.components.SquareSpinIndicator
import com.spr.jetpack_loading.components.TriangleSpinIndicator

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

    val rowHeight: Dp = 50.dp

    // get screen height and width
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

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
            GridIndicator(animationType = GridAnimationType.PULSATING)
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
            CubeTransitionIndicator()
            BallZigZagIndicator()
            BallZigZagDeflectIndicator()
            BallTrianglePathIndicator()
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
            GridIndicator(animationType = GridAnimationType.BEATING)
            SemiCircleSpinIndicator(canvasSize = screenWidthDp / 9)
        }
    }
}