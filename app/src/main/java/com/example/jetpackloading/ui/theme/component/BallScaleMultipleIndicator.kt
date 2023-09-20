package com.example.jetpackloading.ui.theme.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallScaleMultipleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    largestBallDiameter: Float = 70f,
    animationDuration: Int = 1500,
    minScale: Float = 0f,
    maxScale: Float = 2.5f,
    rippleCount: Int = 4,
    alpha: Float = 0.3f
) {


    val smallestBallDiameter = largestBallDiameter / rippleCount
    val diameterSteps = (largestBallDiameter - smallestBallDiameter) / rippleCount

    val scales: List<Float> = (0 until rippleCount).map { index ->
        var scale by remember { mutableStateOf(minScale) }

        LaunchedEffect(key1 = Unit) {

            animate(
                initialValue = minScale,
                targetValue = maxScale,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = (rippleCount - index) * animationDuration / rippleCount,
                        delayMillis = index * animationDuration / rippleCount,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart,
                ),
            ) { value, _ -> scale = value }
        }
        scale
    }

    Canvas(modifier = Modifier) {
        for (index in 0 until rippleCount) {
            val radius = (largestBallDiameter / 2) - (index * (diameterSteps / 2))
            drawCircle(
                color = color,
                center = Offset(size.width/2 + largestBallDiameter, size.height/2),
                radius = radius * scales[index],
                alpha = alpha
            )
        }
    }
}