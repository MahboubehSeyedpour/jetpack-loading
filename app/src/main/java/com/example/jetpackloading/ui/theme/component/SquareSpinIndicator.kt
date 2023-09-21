package com.example.jetpackloading.ui.theme.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import com.example.jetpackloading.enums.RotationAxis
import com.example.jetpackloading.enums.SquareCardFace
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SquareSpinIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    animationDelay: Int = 800,
    canvasSize: Dp = 30.dp,
) {

    var squareCardFace by remember { mutableStateOf(SquareCardFace.AxisX) }
    var axis by remember { mutableStateOf(RotationAxis.AxisX) }
    val transition = rememberInfiniteTransition()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(squareCardFace) {
        axis = squareCardFace.axis
    }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            while (true) {
                delay(animationDelay.toLong())
                squareCardFace = squareCardFace.next
            }
        }
    }

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = squareCardFace.angle,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = animationDelay,
                easing = FastOutSlowInEasing,
            )
        )
    )

    Canvas(modifier = Modifier
        .size(canvasSize)
        .graphicsLayer {
            if (axis == RotationAxis.AxisX) {
                rotationX = rotation
            } else {
                rotationY = rotation
            }
        }) {

        val squareSize = canvasSize.toPx()

        val left = (size.width - squareSize) / 2
        val top = (size.height - squareSize) / 2
        val right = left + squareSize
        val bottom = top + squareSize

        val squareRect = Rect(left, top, right, bottom)

        drawRect(
            color = color,
            size = squareRect.size
        )
    }
}