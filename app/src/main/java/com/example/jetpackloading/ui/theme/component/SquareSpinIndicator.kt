package com.example.jetpackloading.ui.theme.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import com.example.jetpackloading.SQUARE_ANIMATION_DELAY
import com.example.jetpackloading.SQUARE_SIZE
import com.example.jetpackloading.enums.SquareCardFace
import com.example.jetpackloading.enums.RotationAxis
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SquareSpinIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    size: Dp = SQUARE_SIZE,
    animationDelay: Int = SQUARE_ANIMATION_DELAY
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

    Card(
        modifier = Modifier
            .graphicsLayer {
                if (axis == RotationAxis.AxisX) {
                    rotationX = rotation
                } else {
                    rotationY = rotation
                }
//                cameraDistance = 12f * density
            },
        shape = RectangleShape
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color)
        )
    }
}