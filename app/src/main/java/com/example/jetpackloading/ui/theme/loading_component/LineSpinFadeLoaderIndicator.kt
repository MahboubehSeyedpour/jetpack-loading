package com.example.jetpackloading.ui.theme.loading_component

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
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import com.example.jetpackloading.enums.AnimationType
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LineSpinFadeLoaderIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    rectCount: Int = 8,
    animationType: AnimationType = AnimationType.CIRCULAR,
    penThickness: Float = 25f,
    radius: Float = 55f,
    elementHeight: Float = 20f,
    minAlpha: Float = 0.2f,
    maxAlpha: Float = 1.0f
) {

    val angleStep = 360f / rectCount
    val outerRadius = radius + elementHeight
    val innerRadius = radius


// ------------------------ scale animation ---------------------
    val alphas = (1..rectCount).map { index ->
        var alpha: Float by remember { mutableStateOf(minAlpha) }
        LaunchedEffect(key1 = Unit) {

            when (animationType) {
                AnimationType.CIRCULAR -> {
                    delay(animationType.circleDelay * index)
                }

                AnimationType.SKIP_AND_REPEAT -> {
                    delay(animationType.circleDelay * index) // The constant value, here 250L, must be the same animation duration for this pattern to run
                }
            }

            animate(
                initialValue = minAlpha,
                targetValue = maxAlpha,
                animationSpec = infiniteRepeatable(
                    animation = when (animationType) {
                        AnimationType.CIRCULAR -> {
                            tween(durationMillis = animationType.animDuration)
                        }

                        AnimationType.SKIP_AND_REPEAT -> {
                            tween(durationMillis = animationType.animDuration)
                        }
                    },
                    repeatMode = RepeatMode.Reverse,
                )
            ) { value, _ -> alpha = value }
        }

        alpha
    }


// ----------------------------- UI --------------------------

    Canvas(modifier = Modifier) {

        val center = Offset(size.width / 2, size.height / 2)

        for (index in 0 until rectCount) {

            val angle = index * angleStep

            val startX =
                center.x + innerRadius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val startY =
                center.y + innerRadius * sin(Math.toRadians(angle.toDouble())).toFloat()

            val endX = center.x + outerRadius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val endY = center.y + outerRadius * sin(Math.toRadians(angle.toDouble())).toFloat()

            drawLine(
                color = color,
                start = Offset(startX, startY),
                end = Offset(endX, endY),
                strokeWidth = penThickness * alphas[index],
                alpha = alphas[index],
                cap = StrokeCap.Round,
            )
        }
    }
}