package com.example.jetpackloading.ui.theme.loading_component

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
    color: Color = ANIMATION_DEFAULT_COLOR
) {

    val alpha by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(550, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val scale by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1100, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = Modifier) {
        drawCircle(
            color = color,
            radius = 35f * scale,
            alpha = alpha
        )
    }
}