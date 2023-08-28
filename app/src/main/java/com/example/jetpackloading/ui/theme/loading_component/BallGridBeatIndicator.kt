package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallGridBeatIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR
) {

    val rowCount = 3
    val colCount = 3

    @Composable
    fun alpha(animationDelay: Int) = rememberInfiniteTransition().animateFloat(
        initialValue = 0.5f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDelay
                0.6f at animationDelay / 4 with LinearEasing
                0.8f at animationDelay / 2 with LinearEasing
                1f at animationDelay
            }, repeatMode = RepeatMode.Reverse
        )
    )

    Column {
        repeat(rowCount) { row ->
            Row {
                repeat(colCount) { col ->
                    Dot(color, alpha = alpha(animationDelay = (row + col + colCount) * 120).value)
                }
            }
        }
    }
}

@Composable
fun Dot(color: Color, alpha: Float) {
    Box(
        Modifier
            .padding(2.dp)
            .alpha(alpha)
            .background(
                color = color, shape = CircleShape
            )
            .size(10.dp)
    )
}