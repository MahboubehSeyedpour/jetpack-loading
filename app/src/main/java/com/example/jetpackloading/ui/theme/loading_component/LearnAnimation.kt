package com.example.jetpackloading.ui.theme.loading_component

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackloading.R

enum class BikePosition {
    Start, Finish
}

@Composable
fun LearnAnimation() {
    var bikeState by remember { mutableStateOf(BikePosition.Start) }

//    val offsetAnimation: Dp by animateDpAsState(
//        if (bikeState == BikePosition.Start) 5.dp else 300.dp,
//    )
//    val offsetAnimation: Dp by animateDpAsState(
//        if (bikeState == BikePosition.Start) 5.dp else 250.dp,
//        spring(stiffness = Spring.StiffnessHigh)
//    )
//    val offsetAnimation: Dp by animateDpAsState(
//        if (bikeState == BikePosition.Start) 5.dp else 300.dp,
//        tween(5000)
//    )
//    val offsetAnimation: Dp by animateDpAsState(
//        if (bikeState == BikePosition.Start) 5.dp else 250.dp,
//        tween(1000, easing = CubicBezierEasing(1.0f, 0.0f, 0.0f, 1.0f))
//    )
    val offsetAnimation: Dp by animateDpAsState(
        if (bikeState == BikePosition.Start) 5.dp else 250.dp,

        keyframes {
            durationMillis = 3000
            50.dp.at(2900)
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    )  {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .absoluteOffset(x = offsetAnimation)
        )
        Button(
            onClick = {
                bikeState = when (bikeState) {
                    BikePosition.Start -> BikePosition.Finish
                    BikePosition.Finish -> BikePosition.Start
                }
            }, modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        ) {
            Text(text = "Ride")
        }
    }
}