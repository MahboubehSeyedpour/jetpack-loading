package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BallPulseSyncIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    ballCount: Int = 3,
    spaceBetweenBalls: Float = 20f,
    ballDiameter: Float = 20f,
    animationDuration: Int = 900,
    amplitude: Float = 50f
) {
    val transition = rememberInfiniteTransition(label = "BallPulseSync")

    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = (2f * Math.PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "Progress"
    )

    val totalWidth =
        ballCount * ballDiameter + (ballCount - 1) * spaceBetweenBalls

    val totalHeight =
        ballDiameter + amplitude * 2f

    Canvas(
        modifier = modifier.size(
            width = totalWidth.dp,
            height = totalHeight.dp
        )
    ) {
        val centerY = size.height / 2f
        val startX = ballDiameter / 2f
        val step = ballDiameter + spaceBetweenBalls

        repeat(ballCount) { index ->

            val phase =
                progress - index * (Math.PI.toFloat() / 4f)

            val offset =
                ((kotlin.math.sin(phase) + 1f) / 2f) * amplitude

            drawCircle(
                color = color,
                radius = ballDiameter / 2f,
                center = Offset(
                    x = startX + index * step,
                    y = centerY - offset
                )
            )
        }
    }
}