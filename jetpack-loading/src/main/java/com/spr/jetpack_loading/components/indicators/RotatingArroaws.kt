package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spr.jetpack_loading.extension.toRadian
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun RotatingArrows(
    color: Color = Color.White,
    animationDuration: Int = 1000,
    canvasSize: Float = 70f,
    penThickness: Dp = 5.dp
) {

    val clockwiseRotation = true

    // ------------  Animations -----------------------
    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box {
        DrawCurvedArc(
            color = color,
            radius = canvasSize,
            startAngle = 30f,
            sweepAngle = 150f,
            penThickness = penThickness,
            clockwiseRotation = clockwiseRotation,
            rotation = rotation
        )

        DrawCurvedArc(
            color = color,
            radius = canvasSize,
            startAngle = 210f,
            sweepAngle = 150f,
            penThickness = penThickness,
            clockwiseRotation = clockwiseRotation,
            rotation = rotation
        )
    }
}

@Composable
fun DrawCurvedArc(
    color: Color,
    radius: Float,
    startAngle: Float,
    sweepAngle: Float,
    penThickness: Dp,
    clockwiseRotation: Boolean,
    rotation: Float = 0f
) {

    val arcEnd = startAngle + sweepAngle
    val x0 = radius * (cos((if (clockwiseRotation) arcEnd else startAngle).toRadian())).toFloat()
    val y0 = radius * sin((if (clockwiseRotation) arcEnd else startAngle).toRadian()).toFloat()
    val alpha = (if (clockwiseRotation) startAngle + 10 else arcEnd + 10).toRadian()
    val beta = (if (clockwiseRotation) startAngle + 80 else arcEnd + 80).toRadian()

    Canvas(modifier = Modifier) {

        rotate(rotation) {

//            drawCircle(
//                color = Color.Black,
//                radius = radius
//            )


            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                topLeft = Offset(-radius, -radius),
                useCenter = false,
                style = Stroke(width = penThickness.toPx(), cap = StrokeCap.Round),
                size = Size(2 * radius, 2 * radius)
            )


            drawLine(
                color = color,
                start = Offset(x = x0, y = y0),
                end = Offset(
                    x0 + (radius / 2) * cos(alpha).toFloat(),
                    y0 + (radius / 2) * sin(alpha).toFloat()
                ),
                strokeWidth = penThickness.toPx(),
                cap = StrokeCap.Round
            )


            drawLine(
                color = color,
                start = Offset(x = x0, y = y0),
                end = Offset(
                    x0 + (radius / 2) * cos(beta).toFloat(),
                    y0 + (radius / 2) * sin(beta).toFloat()
                ),
                strokeWidth = penThickness.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}