package com.example.jetpack_loading.indicators.shape_unveil_indicator

import androidx.compose.animation.core.FastOutSlowInEasing
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CircleShapeIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    canvasSize: Float = 1000f,
    circleDiameter: Float = canvasSize / 10,
    animationDuration: Int = 3000,
    circleCounts: Int = 6
) {

    val xOffsets: List<Float> = (0 until circleCounts).map { index ->
        var xOffset by remember { mutableStateOf(0f) }

        val angle = (index * 2 * kotlin.math.PI / circleCounts).toFloat()

        LaunchedEffect(key1 = Unit) {

            delay(index * (animationDuration / (2 * circleCounts)).toLong())

            animate(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = animationDuration
                        cos(angle) * (circleDiameter) at animationDuration / (2 * circleCounts) with FastOutSlowInEasing
                        cos(angle) * (circleDiameter) at animationDuration / 2 with FastOutSlowInEasing
                        0f at animationDuration / 2 + animationDuration / (2 * circleCounts) with FastOutSlowInEasing
                        0f at animationDuration with FastOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart,
                ),
            ) { value, _ -> xOffset = value }
        }
        xOffset
    }

    val yOffsets: List<Float> = (0 until circleCounts).map { index ->
        var yOffset by remember { mutableStateOf(0f) }
        val angle = (index * 2 * kotlin.math.PI / circleCounts).toFloat()

        LaunchedEffect(key1 = Unit) {

            delay(index * (animationDuration / (2 * circleCounts)).toLong())

            animate(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = animationDuration
                        sin(angle) * (circleDiameter) at animationDuration / (2 * circleCounts) with FastOutSlowInEasing
                        sin(angle) * (circleDiameter) at animationDuration / 2 with FastOutSlowInEasing
                        0f at animationDuration / 2 + animationDuration / (2 * circleCounts) with FastOutSlowInEasing
                        0f at animationDuration with FastOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart,
                ),
            ) { value, _ -> yOffset = value }
        }
        yOffset
    }

    Canvas(modifier = modifier) {
        (0 until circleCounts).forEach { circleIndex ->
            drawCircle(
                color = color,
                radius = circleDiameter / 4,
                center = Offset(
                    x = size.width / 2 + xOffsets[circleIndex],
                    y = size.height / 2 + yOffsets[circleIndex]
                )
            )
        }
    }
}