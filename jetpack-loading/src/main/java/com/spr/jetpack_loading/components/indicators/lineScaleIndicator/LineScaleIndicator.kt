package com.spr.jetpack_loading.components.indicators.lineScaleIndicator

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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.spr.jetpack_loading.enums.PunchType

@Composable
fun LineScaleIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    rectCount: Int = 5,
    distanceOnXAxis: Float = 30f,
    lineHeight: Int = 100,
    animationDuration: Int = 2000,
    punchType: PunchType,
    lineType: StrokeCap = StrokeCap.Round,
    minScale: Float = 0.3f,
    maxScale: Float = 1.5f,
    penThickness: Float = 10f
) {
    val transition = rememberInfiniteTransition(label = "LineScale")

    val progress by transition.animateFloat(
        initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration, easing = LinearEasing
            ), repeatMode = RepeatMode.Restart
        ), label = "Progress"
    )

    val width = ((rectCount - 1) * distanceOnXAxis + penThickness).dp
    val height = lineHeight.dp

    Canvas(
        modifier = modifier.size(width, height)
    ) {
        val centerY = size.height / 2f
        val centerIndex = (rectCount - 1) / 2f

        repeat(rectCount) { index ->

            val scale = when (punchType) {

                PunchType.RANDOM_PUNCH -> {
                    val phase = (progress + index.toFloat() / rectCount) % 1f
                    val value = 0.5f + 0.5f * kotlin.math.sin(
                        phase * (2f * Math.PI).toFloat()
                    )

                    androidx.compose.ui.util.lerp(
                        minScale, maxScale, value
                    )
                }

                PunchType.ACCORDION_PUNCH -> {
                    val distance = kotlin.math.abs(index - centerIndex)
                    val phase = (progress + distance / rectCount) % 1f

                    val value = 0.5f + 0.5f * kotlin.math.sin(
                        phase * (2f * Math.PI).toFloat()
                    )

                    androidx.compose.ui.util.lerp(
                        minScale, maxScale, value
                    )
                }

                PunchType.SYMMETRIC_PUNCH -> {
                    val pulse = progress * centerIndex
                    val distance = kotlin.math.abs(index - centerIndex)

                    val intensity = kotlin.math.exp(
                        -((distance - pulse) * (distance - pulse)) / (2f * 0.35f * 0.35f)
                    )

                    minScale + (maxScale - minScale) * intensity
                }

                PunchType.PULSE_OUT_PUNCH -> {
                    val pulse = progress * (rectCount - 1)
                    val distance = kotlin.math.abs(index - pulse)

                    val intensity = kotlin.math.exp(
                        -(distance * distance) / (2f * 0.45f * 0.45f)
                    )

                    minScale + (maxScale - minScale) * intensity
                }
            }

            val x = index * distanceOnXAxis

            drawLine(
                color = color, start = Offset(
                    x, centerY - lineHeight / 2f * scale
                ), end = Offset(
                    x, centerY + lineHeight / 2f * scale
                ), strokeWidth = penThickness, cap = lineType
            )
        }
    }
}