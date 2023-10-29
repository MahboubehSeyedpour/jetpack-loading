package com.spr.jetpack_loading.components.indicators

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.spr.jetpack_loading.enums.SwapSpinStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SwapSpinIndicator(
    animationDuration: Int = 200,
    ballSize: Float = 50f,
    canvasSize: Float = 30f
) {

    val coroutineScope = rememberCoroutineScope()

    var firstCirSt by remember { mutableStateOf(SwapSpinStates.TO_RIGHT) } // first circle state
    var secCirSt by remember { mutableStateOf(SwapSpinStates.STAY_TO_UP) } // second circle state
    var thirdCirSt by remember { mutableStateOf(SwapSpinStates.BOTTOM_TO_STAY) } // third circle state

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            while (true) {
                delay(animationDuration.toLong())
                firstCirSt = firstCirSt.next
                secCirSt = secCirSt.next
                thirdCirSt = thirdCirSt.next
            }
        }
    }

//    ------------------ circle #1 ----------------
    val firstCircleX by rememberInfiniteTransition().animateFloat(
        initialValue = firstCirSt.xStartCoe * canvasSize,
        targetValue = firstCirSt.xEndCoe * canvasSize,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                canvasSize * firstCirSt.xStartCoe at animationDuration / 2 with LinearEasing
                (canvasSize * firstCirSt.xStartCoe) + (canvasSize * (firstCirSt.xEndCoe - firstCirSt.xStartCoe) / 2) at 3 * animationDuration / 4 with LinearEasing
                canvasSize * firstCirSt.xEndCoe at animationDuration with LinearEasing
            },
            repeatMode = RepeatMode.Restart,
        )
    )

    val firstCircleY by rememberInfiniteTransition().animateFloat(
        initialValue = canvasSize * firstCirSt.yStartCoe,
        targetValue = canvasSize * firstCirSt.yEndCoe,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                canvasSize * firstCirSt.yStartCoe at animationDuration / 2 with LinearEasing
                (canvasSize * firstCirSt.yStartCoe) + (canvasSize * (firstCirSt.yEndCoe - firstCirSt.yStartCoe) / 2) at 3 * animationDuration / 4 with LinearEasing
                canvasSize * firstCirSt.yEndCoe at animationDuration with LinearEasing
            },
            repeatMode = RepeatMode.Restart,
        )
    )

//    ------------------ circle #2 ----------------
    val secondCircleX by rememberInfiniteTransition().animateFloat(
        initialValue = canvasSize * secCirSt.xStartCoe,
        targetValue = canvasSize * secCirSt.xEndCoe,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                canvasSize * secCirSt.xStartCoe at animationDuration / 2 with LinearEasing
                (canvasSize * secCirSt.xStartCoe) + (canvasSize * (secCirSt.xEndCoe - secCirSt.xStartCoe) / 2) at 3 * animationDuration / 4 with LinearEasing
                canvasSize * secCirSt.xEndCoe at animationDuration with LinearEasing
            },
            repeatMode = RepeatMode.Restart,
        )
    )

    val secondCircleY by rememberInfiniteTransition().animateFloat(
        initialValue = canvasSize * secCirSt.yStartCoe,
        targetValue = canvasSize * secCirSt.yEndCoe,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                canvasSize * secCirSt.yStartCoe at animationDuration / 2 with LinearEasing
                (canvasSize * secCirSt.yStartCoe) + (canvasSize * (secCirSt.yEndCoe - secCirSt.yStartCoe) / 2) at 3 * animationDuration / 4 with LinearEasing
                canvasSize * secCirSt.yEndCoe at animationDuration with LinearEasing
            },
            repeatMode = RepeatMode.Restart,
        )
    )


//    ------------------ circle #3 ----------------
    val thirdCircleX by rememberInfiniteTransition().animateFloat(
        initialValue = canvasSize * thirdCirSt.xStartCoe,
        targetValue = canvasSize * thirdCirSt.xEndCoe,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                canvasSize * thirdCirSt.xStartCoe at animationDuration / 2 with LinearEasing
                (canvasSize * thirdCirSt.xStartCoe) + (canvasSize * (thirdCirSt.xEndCoe - thirdCirSt.xStartCoe) / 2) at 3 * animationDuration / 4 with LinearEasing
                canvasSize * thirdCirSt.xEndCoe at animationDuration with LinearEasing
            },
            repeatMode = RepeatMode.Restart,
        )
    )

    val thirdCircleY by rememberInfiniteTransition().animateFloat(
        initialValue = canvasSize * thirdCirSt.yStartCoe,
        targetValue = canvasSize * thirdCirSt.yEndCoe,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                canvasSize * thirdCirSt.yStartCoe at animationDuration / 2 with LinearEasing
                (canvasSize * thirdCirSt.yStartCoe) + (canvasSize * (thirdCirSt.yEndCoe - thirdCirSt.yStartCoe) / 2) at 3 * animationDuration / 4 with LinearEasing
                canvasSize * thirdCirSt.yEndCoe at animationDuration with LinearEasing
            },
            repeatMode = RepeatMode.Restart,
        )
    )


    Canvas(modifier = Modifier) {

        // ---- circle #1 ------
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(firstCircleX, firstCircleY),
            size = Size(width = ballSize, height = ballSize),
            cornerRadius = CornerRadius(50f, 50f)
        )

        // ---- circle #2 ------
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(secondCircleX, secondCircleY),
            size = Size(ballSize, ballSize),
            cornerRadius = CornerRadius(50f, 50f),
        )

        // ---- circle #3 ------
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(thirdCircleX, thirdCircleY),
            size = Size(ballSize, ballSize),
            cornerRadius = CornerRadius(50f, 50f),
        )
    }
}