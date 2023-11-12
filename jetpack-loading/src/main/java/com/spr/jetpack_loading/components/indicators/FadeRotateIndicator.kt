package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun FadeRotateIndicator(
    color: Color = Color.White,
    animationDuration: Int = 1500,
    sideLength: Float = 50f,
    cornerRadius: Float = 10f,
    gap: Float = 2f,
    alphaMinValue: Float = 0f,
    alphaMaxValue: Float = 1f,
) {
    val rectCount = 4

    val alphas: List<Float> = (0 until rectCount).map { index ->
        var alpha by remember { mutableStateOf(alphaMinValue) }

        LaunchedEffect(key1 = Unit) {
            delay(if (index == 0) animationDuration.toLong() else index * (animationDuration / 4).toLong())
            animate(
                initialValue = alphaMinValue,
                targetValue = alphaMinValue,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = animationDuration
                        alphaMinValue at 0 with FastOutSlowInEasing
                        alphaMaxValue at durationMillis / 4 with FastOutSlowInEasing
                        alphaMinValue at durationMillis with LinearEasing
                    },
                    repeatMode = RepeatMode.Restart,
                ),
            ) { value, _ -> alpha = value }
        }
        alpha
    }

    Canvas(modifier = Modifier) {

        drawRoundRect(
            color = color,
            topLeft = Offset(
                x = size.width - (sideLength / 2 + gap),
                y = size.height - (sideLength / 2 + gap)
            ),
            size = Size(sideLength, sideLength),
            cornerRadius = CornerRadius(cornerRadius),
            alpha = alphas[0]
        )

        drawRoundRect(
            color = color,
            topLeft = Offset(
                x = size.width + (sideLength / 2 + gap),
                y = size.height - (sideLength / 2 + gap)
            ),
            size = Size(sideLength, sideLength),
            cornerRadius = CornerRadius(cornerRadius),
            alpha = alphas[1]
        )

        drawRoundRect(
            color = color,
            topLeft = Offset(
                x = size.width + (sideLength / 2 + gap),
                y = size.height + (sideLength / 2 + gap)
            ),
            size = Size(sideLength, sideLength),
            cornerRadius = CornerRadius(cornerRadius),
            alpha = alphas[2]
        )

        drawRoundRect(
            color = color,
            topLeft = Offset(
                x = size.width - (sideLength / 2 + gap),
                y = size.height + (sideLength / 2 + gap)
            ),
            size = Size(sideLength, sideLength),
            cornerRadius = CornerRadius(cornerRadius),
            alpha = alphas[3]
        )
    }
}