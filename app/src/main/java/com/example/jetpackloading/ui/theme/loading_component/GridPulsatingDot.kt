package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import com.example.jetpackloading.DOTS_COUNT
import com.example.jetpackloading.DOT_SIZE
import com.example.jetpackloading.PULSE_DELAY

@Composable
fun GridPulsatingDot(
    color: Color = ANIMATION_DEFAULT_COLOR,
    dotSize: Dp = DOT_SIZE,
    pulseDelay: Int = PULSE_DELAY,
    rowCount: Int = DOTS_COUNT,
    colCount: Int = DOTS_COUNT
) {
    val infiniteTransition = rememberInfiniteTransition()

    @Composable
    fun Dot(
        scale: Float
    ) = Spacer(
        Modifier
            .size(dotSize)
            .scale(scale)
            .background(
                color = color,
                shape = CircleShape
            )
    )

    @Composable
    fun PulsatingDotWithDelay(delay: Int) = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = pulseDelay * 4
                0f at delay with LinearEasing
                1f at delay + pulseDelay with LinearEasing
                0f at delay + pulseDelay * 2
            }
        )
    )

    val dots: MutableList<State<Float>> = mutableListOf()

    for (rowIndex in 0 until rowCount) {
        for (colIndex in 0 until colCount) {
            dots.add(PulsatingDotWithDelay(delay = (pulseDelay * (rowIndex * colCount + colIndex) * 0.3).toInt()))
        }
    }

    Column {
        val spaceSize = 2.dp
        for (rowIndex in 0 until rowCount) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                for (colIndex in 0 until colCount) {
                    val flatListIndex = rowIndex * colCount + colIndex
                    Dot(dots[flatListIndex].value)
                    Spacer(Modifier.width(spaceSize))
                }
            }
        }
    }
}