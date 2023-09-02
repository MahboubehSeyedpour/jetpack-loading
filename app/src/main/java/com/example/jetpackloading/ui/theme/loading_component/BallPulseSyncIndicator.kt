package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import kotlinx.coroutines.delay

@Composable
fun BallPulseSyncIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    ballCount: Int = 3,
    delay: Long = 100L
) {

    val animationValues = (1..ballCount).map { index ->

        var animatedValue: Float by remember { mutableStateOf(0f) }

        LaunchedEffect(key1 = Unit) {
            delay(delay * index)

            animate(
                initialValue = 0f,
                targetValue = 12f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 300),
                    repeatMode = RepeatMode.Reverse,
                )
            ) { value, _ -> animatedValue = value }
        }

        animatedValue
    }

    Row {
        for (animatedValue in animationValues) {
            Canvas(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .offset(y = animatedValue.dp),
            ) {
                drawCircle(
                    color = color,
                    radius = 30f
                )
            }
        }
    }
}
