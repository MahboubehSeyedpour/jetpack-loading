package com.example.jetpackloading

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// ------------------------------------- global values ---------------------------------------------
// dimens
val rowHeight: Dp = 50.dp

// color
val ANIMATION_DEFAULT_COLOR = Color.White


// ---------------------------------- component special values -------------------------------------

//PulsatingDot & GridPulsatingDot
const val DOTS_COUNT: Int = 3
const val PULSE_DELAY: Int = 300 // in milliseconds
val DOT_SIZE: Dp = 10.dp


// SquareSpinIndicator
val SQUARE_SIZE: Dp = 30.dp
const val SQUARE_ANIMATION_DELAY: Int = 850 // in milliseconds

// TriangleSpinIndicator
const val TRIANGLE_ANIMATION_DELAY: Int = 850 // in milliseconds