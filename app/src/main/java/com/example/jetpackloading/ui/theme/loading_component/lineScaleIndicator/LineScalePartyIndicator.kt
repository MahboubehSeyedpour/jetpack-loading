package com.example.jetpackloading.ui.theme.loading_component.lineScaleIndicator

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap

@Composable
internal fun LineScalePartyIndicator(
    color: Color,
    rectCount: Int
) {
    val xStep = 30f
    val lineHeight = 100
    val delay = 500

    val scales: List<Float> = (0 until rectCount).map { index ->
        var scale by remember { mutableStateOf(0f) }

        LaunchedEffect(key1 = Unit) {
            animate(
                initialValue = 0.3f,
                targetValue = 1.5f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = delay,
                        delayMillis = 50 * index,
                        easing = FastOutLinearInEasing
                    ),
                    repeatMode = RepeatMode.Reverse,
                ),
            ) { value, _ ->
                scale = value
            }
        }
        scale
    }

    Canvas(modifier = Modifier) {
        for (index in 0 until rectCount) {
            drawLine(
                color = color,
                start = Offset(index * xStep, -lineHeight / 2 * scales[index]),
                end = Offset(index * xStep, lineHeight / 2 * scales[index]),
                strokeWidth = 15f,
                cap = StrokeCap.Square,
            )
        }
    }
}