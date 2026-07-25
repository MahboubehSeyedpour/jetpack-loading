package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.FastOutSlowInEasing
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Composable
fun BallBeatIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    ballCount: Int = 3,
    ballDiameter: Float = 20f,
    spaceBetweenBalls: Float = 20f,
    animationDuration: Int = 1200,
    minAlpha: Float = 0.2f,
    maxAlpha: Float = 1f
) {
    val transition = rememberInfiniteTransition(label = "BallBeat")

    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = ballCount.toFloat(),
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

    Canvas(
        modifier = modifier.size(
            width = totalWidth.dp,
            height = ballDiameter.dp
        )
    ) {
        val step = ballDiameter + spaceBetweenBalls
        val centerY = size.height / 2
        val startX = ballDiameter / 2

        repeat(ballCount) { index ->

            val distance = kotlin.math.abs(progress - index)

            val alpha = when {
                distance >= 1f -> minAlpha
                else -> maxAlpha - (maxAlpha - minAlpha) * distance
            }

            drawCircle(
                color = color,
                radius = ballDiameter / 2,
                alpha = alpha,
                center = Offset(
                    x = startX + index * step,
                    y = centerY
                )
            )
        }
    }
}