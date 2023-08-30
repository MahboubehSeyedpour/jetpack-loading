package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallScaleRippleMultipleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR
) {

    //Outer circle
    val scale1 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale2 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 600, delayMillis = 600, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale3 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 400, delayMillis = 800, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    // Inner circle
    val scale4 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(200, delayMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box {
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .scale(scale1)
        ) {
            drawCircle(
                color = color,
                radius = 35f,
                style = Stroke(width = 3f),
            )
        }
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .scale(scale2)
        ) {
            drawCircle(
                color = color,
                alpha = 0.7f,
                radius = 25f,
                style = Stroke(width = 3f)
            )
        }
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .scale(scale3)
        ) {
            drawCircle(
                color = color,
                alpha = 0.5f,
                radius = 15f,
                style = Stroke(width = 3f)
            )
        }
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .scale(scale4)
        ) {
            drawCircle(
                color = color,
                alpha = 0.3f,
                radius = 5f,
                style = Stroke(width = 3f)
            )
        }
    }

}