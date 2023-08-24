package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.FastOutSlowInEasing
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun SemiCircleSpinIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
) {

    val rotation by rememberInfiniteTransition().animateFloat(
        initialValue = -90f,
        targetValue = 270f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 600, delayMillis = -1, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(
        modifier = Modifier
            .size(40.dp)
            .graphicsLayer {
                rotationZ = rotation
                cameraDistance = 12f * density
            }
    ) {

        drawArc(color)
    }
}

private fun DrawScope.drawArc(color: Color) {

    val topLeft = Offset(0f, 0f)
    val size = Size(size.width, size.height)
    val startAngle = 0f // Start angle in degrees
    val sweepAngle = 180f // Sweep angle in degrees

    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        topLeft = topLeft,
        size = size,
        useCenter = true
    )
}