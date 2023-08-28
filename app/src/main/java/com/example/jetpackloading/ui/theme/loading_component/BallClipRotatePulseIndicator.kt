package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.FastOutSlowInEasing
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallClipRotatePulseIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
) {

    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by transition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box {

        Canvas(
            modifier = Modifier
                .size(40.dp)
                .scale(scale)
                .graphicsLayer {
                    rotationZ = rotation
                }
        ) {

            drawArc(
                color = color,
                startAngle = 202.5f,
                sweepAngle = 135f,
                useCenter = false,
                style = Stroke(width = 7f, cap = StrokeCap.Round),
            )

            drawCircle(
                color = color,
                radius = 35f,
            )

            drawArc(
                color = color,
                startAngle = 22.5f,
                sweepAngle = 135f,
                useCenter = false,
                style = Stroke(width = 7f, cap = StrokeCap.Round),
            )
        }
    }
}