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
import com.example.jetpackloading.extension.mirror
import kotlinx.coroutines.delay

@Composable
fun LineScalePulseOutIndicator(
    color: Color,
    rectCount: Int
) {

    val xStep = 30f
    val lineHeight = 100
    val duration = 500

    var indexList = mutableListOf<Int>()
    for (index in 0..rectCount / 2) {
        indexList.add(index)
    }
    indexList = indexList.toList().mirror().toMutableList()


    val scales: List<Float> = indexList.map { index ->
        var scale by remember { mutableStateOf(0f) }

        LaunchedEffect(key1 = Unit) {

            delay(duration / 2L * index)

            animate(
                initialValue = 0.3f,
                targetValue = 1.5f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = duration, easing = FastOutLinearInEasing),
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
                cap = StrokeCap.Round,
            )
        }
    }
}