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
fun BallScaleRippleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR
) {

    val scale by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1100, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box {
        Canvas(
            modifier = Modifier
                .scale(scale)
        ) {
            drawCircle(
                color = color,
                radius = 35f,
                style = Stroke(width = 5f)
            )
        }
    }
}