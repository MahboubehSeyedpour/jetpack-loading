package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun PacmanIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
) {

    val positionAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = 30f,
        targetValue = -12f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 900, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val upperLipAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = 360F,
        targetValue = 290F,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val lowerLipAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = 0F,
        targetValue = 40F,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )


    Box(modifier = Modifier.size(50.dp), contentAlignment = Alignment.Center) {

        Canvas(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.Center)
        ) {
            drawArc(color, upperLipAnimation, lowerLipAnimation)
        }

        Box(
            modifier = Modifier
                .offset(positionAnimation.dp)
                .align(Alignment.Center)
                .size(12.dp)
                .clip(CircleShape)
                .background(color)

        ) {}
    }
}

private fun DrawScope.drawArc(color: Color, upperAnimation: Float, lowerAnimation: Float) {
    drawArc(
        color = color,
        startAngle = lowerAnimation,
        sweepAngle = upperAnimation,
        topLeft = Offset(0f, 0f),
        size = Size(size.width, size.height),
        useCenter = true
    )
}