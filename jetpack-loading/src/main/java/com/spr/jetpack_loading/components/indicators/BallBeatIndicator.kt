package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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
    ballDiameter: Float = 40f,
    spaceBetweenBalls: Float = 20f,
    animationDuration: Int = 350,
    staggerDelay: Long = 150,
    minAlpha: Float = 0.4f,
    maxAlpha: Float = 1f
) {
    val transition = rememberInfiniteTransition()

    val alphas = (0 until ballCount).map { index ->
        transition.animateFloat(
            initialValue = minAlpha,
            targetValue = maxAlpha,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = animationDuration,
                    delayMillis = (abs(index - (ballCount - 1) / 2) * staggerDelay).toInt()
                ),
                repeatMode = RepeatMode.Reverse
            ),
        )
    }

    val totalWidth = ballCount * ballDiameter + (ballCount - 1) * spaceBetweenBalls

    Canvas(
        modifier = modifier.size(width = totalWidth.dp, height = ballDiameter.dp)
    ) {
        val xOffset = ballDiameter + spaceBetweenBalls
        val centerY = size.height / 2
        val centerXOffset = (ballCount - 1) * xOffset / 2f

        for (index in 0 until ballCount) {
            val currentAlpha = alphas[index].value

            drawCircle(
                color = color,
                radius = ballDiameter / 2,
                alpha = currentAlpha,
                center = Offset(
                    x = (index * xOffset) - centerXOffset,
                    y = centerY
                )
            )
        }
    }
}
