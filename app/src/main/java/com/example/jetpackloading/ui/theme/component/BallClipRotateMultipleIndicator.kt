package com.example.jetpackloading.ui.theme.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR

@Composable
fun BallClipRotateMultipleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    animationDuration: Int = 600
) {

// ------------  Animations -----------------------
    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by transition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )



    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
// ------------  Outer arcs -----------------------
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .scale(scale)
                .graphicsLayer {
                    rotationZ = rotation
                }
        ) {

            drawArc(
                color = color,
                startAngle = 202.5f,
                sweepAngle = 135f,
                useCenter = false,
                style = Stroke(width = 7f, cap = StrokeCap.Round),
            )

            drawArc(
                color = color,
                startAngle = 22.5f,
                sweepAngle = 135f,
                useCenter = false,
                style = Stroke(width = 7f, cap = StrokeCap.Round),
            )
        }


// ------------  Inner arcs -----------------------
        Canvas(
            modifier = Modifier
                .size(15.dp)
                .scale(scale)
                .graphicsLayer {
                    rotationZ = -rotation
                }
        ) {

            drawArc(
                color = color,
                startAngle = 100f,
                sweepAngle = 150f,
                useCenter = false,
                style = Stroke(width = 7f, cap = StrokeCap.Round),
            )

            drawArc(
                color = color,
                startAngle = 300f,
                sweepAngle = 120f,
                useCenter = false,
                style = Stroke(width = 7f, cap = StrokeCap.Round),
            )
        }
    }
}