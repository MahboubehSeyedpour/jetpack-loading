package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// TODO: Arrows should be written as independent components
@Composable
fun RotatingArrows(
    color: Color = Color.White,
    animationDuration: Int = 1000,
    penThickness: Dp = 4.dp,
    canvasSize: Float = 135f,
    targetRotationValue: Float = 360f
) {

    val penThicknessFloat = with(LocalDensity.current) { penThickness.toPx() }
    val arcSignLength = canvasSize / 7
    val arc1StartAngel = 90f
    val arc2StartAngel = 270f
    val sweepAngle = 120f
    val startRotationValue: Float = 0f


    // ------------  Animations -----------------------
    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = startRotationValue,
        targetValue = targetRotationValue,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )


    // ------------  Paths -----------------------
    /* In this animation, we have two arrows, each of which has a body and a head */

    val arc1Tail = Path().apply {
        addArc(
            oval = Rect(
                left = -canvasSize / 2,
                top = -canvasSize / 2,
                right = canvasSize / 2,
                bottom = canvasSize / 2
            ),
            startAngleDegrees = arc2StartAngel, // Starting angle in degrees
            sweepAngleDegrees = sweepAngle
        )
    }

    val arc1Head = Path()
    arc1Head.moveTo(0f, -canvasSize / 2)
    arc1Head.lineTo(arcSignLength, -canvasSize / 2 + (3 * arcSignLength / 2))
    arc1Head.moveTo(0f, -canvasSize / 2)
    arc1Head.lineTo(arcSignLength, -canvasSize / 2 - arcSignLength)




    val arc2Tail = Path().apply {
        addArc(
            oval = Rect(
                left = -canvasSize / 2,
                top = -canvasSize / 2,
                right = canvasSize / 2,
                bottom = canvasSize / 2
            ),
            startAngleDegrees = arc1StartAngel, // Starting angle in degrees
            sweepAngleDegrees = sweepAngle
        )
    }

    val arc2Head = Path()
    arc2Head.moveTo(0f, canvasSize / 2)
    arc2Head.lineTo(-arcSignLength, canvasSize / 2 + arcSignLength)
    arc2Head.moveTo(0f, canvasSize / 2)
    arc2Head.lineTo(-arcSignLength, canvasSize / 2 - 3 * arcSignLength / 2)


    // ------------ Canvas -----------------------
    Canvas(modifier = Modifier) {
        rotate(-rotation) {
            drawPath(
                path = arc1Tail,
                color = color,
                style = Stroke(width = penThickness.toPx())
            )

            drawPath(
                path = arc1Head,
                color = color,
                style = Stroke(width = penThicknessFloat)
            )

            drawPath(
                path = arc2Tail,
                color = color,
                style = Stroke(width = penThickness.toPx())
            )

            drawPath(
                path = arc2Head,
                color = color,
                style = Stroke(width = penThicknessFloat)
            )
        }
    }
}