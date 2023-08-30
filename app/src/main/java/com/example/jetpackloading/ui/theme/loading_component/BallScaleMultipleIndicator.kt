package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallScaleMultipleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR
) {

    val delay2 = 500
    val delay3 = 800
    val delay4 = 1100

    val duration1 = 1500
    val duration2 = 1000
    val duration3 = 700
    val duration4 = 400

    val canvasSize = 50.dp


// ------------- scale animation --------------------

    //Outer circle
    val scale1 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration1, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale2 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration2,
                delayMillis = delay2,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale3 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration3,
                delayMillis = delay3,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    // Inner circle
    val scale4 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 2.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration4,
                delayMillis = delay4,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

// ------------- alpha animation --------------------
    val alpha1 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration1
                0f at 0 with LinearEasing
                0.3f at duration1 / 2 with LinearEasing
                0f at duration1
            }
        )
    )

    val alpha2 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration2
                0f at 0 with LinearEasing
                0.3f at duration2 / 2 with LinearEasing
                0f at duration2
                delayMillis = delay2
            }
        )
    )

    val alpha3 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration3
                0f at 0 with LinearEasing
                0.3f at duration3 / 2 with LinearEasing
                0f at duration3
                delayMillis = delay3
            }
        )
    )

    val alpha4 by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration4
                0f at 0 with LinearEasing
                0.3f at duration4 / 2 with LinearEasing
                0f at duration4
                delayMillis = delay4
            }
        )
    )

// -------------------- composable ------------------
    Box {
        Canvas(
            modifier = Modifier
                .size(canvasSize)
                .alpha(alpha1)
                .scale(scale1)
        ) {
            drawCircle(
                color = color,
                radius = 35f
            )
        }
        Canvas(
            modifier = Modifier
                .size(canvasSize)
                .alpha(alpha2)
                .scale(scale2)
        ) {
            drawCircle(
                color = color,
                radius = 25f
            )
        }
        Canvas(
            modifier = Modifier
                .size(canvasSize)
                .alpha(alpha3)
                .scale(scale3)
        ) {
            drawCircle(
                color = color,
                radius = 15f
            )
        }
        Canvas(
            modifier = Modifier
                .size(canvasSize)
                .alpha(alpha4)
                .scale(scale4)
        ) {
            drawCircle(
                color = color,
                radius = 5f
            )
        }
    }
}