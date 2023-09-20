package com.example.jetpackloading.ui.theme.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallScaleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    minAlpha: Float = 0f,
    maxAlpha: Float = 0.3f,
    minScale: Float = 0f,
    maxScale: Float = 2.5f,
    animationDuration: Int = 1100,
    ballDiameter: Float = 70f
) {

    val alpha by rememberInfiniteTransition().animateFloat(
        initialValue = minAlpha,
        targetValue = maxAlpha,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by rememberInfiniteTransition().animateFloat(
        initialValue = minScale,
        targetValue = maxScale,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = Modifier) {
        drawCircle(
            color = color,
            radius = (ballDiameter/2) * scale,
            alpha = alpha
        )
    }
}