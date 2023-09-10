package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BallRotateIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    movingBalls: Int = 2,
    diameter: Float = 30f,
    spacing: Float = 60f,
    duration: Int = 1000
) {

    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration
                0f at 0 with FastOutLinearInEasing
                180f at duration / 2 with LinearEasing
                360f at duration with LinearOutSlowInEasing
                delayMillis = 50
            },
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by transition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(duration / 2, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier) {

        val center = Offset(x = size.width / 2, y = size.height / 2)
        val angleStep = 360f / movingBalls

        drawCircle(
            color = color,
            radius = diameter / 2 * scale,
            center = Offset(
                x = center.x,
                y = center.y
            )
        )

        for (index in 0 until movingBalls) {

            val angle = index * angleStep

            drawCircle(
                color = color,
                radius = diameter / 2 * scale,
                center = Offset(
                    x = center.x + ((spacing) * cos(Math.toRadians((angle) + rotation.toDouble())).toFloat()),
                    y = center.y + ((spacing) * sin(Math.toRadians((angle) + rotation.toDouble())).toFloat()),
                )
            )
        }
    }
}