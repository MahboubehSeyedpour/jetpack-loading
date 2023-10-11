package com.example.jetpack_loading.indicators

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

@Composable
fun ShapeUnveil(
    color: Color = Color.White,
    canvasSize: Float = 200f,
    canvasModifier: Modifier = Modifier,
    circleDiameter: Float = canvasSize / 4,
    animationDuration: Int = 3000
) {
    val circleCounts = 6

    val circleDestination =
        listOf(
            0f,
            -canvasSize / 2,
            -canvasSize / 4,
            -canvasSize / 2,
            -canvasSize / 4,
            -canvasSize / 2
        )

    val positions: List<Float> = (0 until circleCounts).map { index ->
        var position by remember { mutableStateOf(0f) }

        LaunchedEffect(key1 = Unit) {

            delay(index * (animationDuration / 10L))

            animate(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = animationDuration
                        circleDestination[index] at animationDuration / 10 with FastOutSlowInEasing
                        circleDestination[index] at animationDuration / 2 with FastOutSlowInEasing
                        0f at 6 * animationDuration / 10 with FastOutSlowInEasing
                        0f at animationDuration with FastOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart,
                ),
            ) { value, _ -> position = value }
        }
        position
    }

    Canvas(modifier = canvasModifier) {

        (0 until circleCounts).map { circleIndex ->
            drawCircle(
                color = color,
                radius = (circleDiameter / 2),
                center = when (circleIndex) {
                    0 -> Offset(x = 0f, 0f)
                    1 -> Offset(positions[circleIndex], 0f)
                    2 -> Offset(positions[circleIndex], positions[circleIndex])
                    3 -> Offset(0f, positions[circleIndex])
                    4 -> Offset(-positions[circleIndex], positions[circleIndex])
                    5 -> Offset(-positions[circleIndex], 0f)
                    else -> Offset(x = 0f, 0f)
                }
            )
        }
    }
}