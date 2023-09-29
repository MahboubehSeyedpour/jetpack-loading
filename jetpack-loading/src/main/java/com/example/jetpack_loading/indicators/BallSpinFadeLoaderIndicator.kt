package com.spr.jetpack_loading.components

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
import com.example.jetpackloading.enums.AnimationType
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BallSpinFadeLoaderIndicator(
    color: Color = Color.White,
    animationType: AnimationType = AnimationType.CIRCULAR,
    radius: Float = 70f,
    ballCount: Int = 8,
    ballRadius: Float = 12f
) {

    val angleStep = 360f / ballCount

// ------------------------ scale animation ---------------------
    val animationValues = (1..ballCount).map { index ->
        var animatedValue: Float by remember { mutableStateOf(0f) }
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
                initialValue = 0.2f,
                targetValue = 1f,
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
            ) { value, _ -> animatedValue = value }
        }

        animatedValue
    }



// ----------------------------- UI --------------------------
    Canvas(
        modifier = Modifier
    ) {
        val center = Offset(size.width / 2, size.height / 2)
        for (index in 0 until ballCount) {
            val angle = index * angleStep
            val x = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val y = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
            drawCircle(
                color = color,
                radius = ballRadius * animationValues[index], // Apply the scale
                center = Offset(x, y)
            )
        }
    }
}