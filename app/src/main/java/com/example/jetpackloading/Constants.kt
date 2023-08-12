package com.example.jetpackloading

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// ------------------------------------- global values ---------------------------------------------
// dimens
val rowWidth: Dp = 400.dp
val rowHeight: Dp = 60.dp

// color
val ANIMATION_DEFAULT_COLOR = Color.White


// ---------------------------------- component special values -------------------------------------

//CircularPulsatingIndicator
const val CIRCULAR_PROGRESS_MAX_SIZE: Float = 6f
const val CIRCULAR_PROGRESS_Min_SIZE: Float = 2.2f
const val ANIMATION_DURATION: Int = 850


//PulsatingDot & GridPulsatingDot
const val DOTS_COUNT: Int = 3
const val PULSE_DELAY: Int = 300 // in milliseconds
val DOT_SIZE: Dp = 10.dp


// SquareSpinIndicator
val SQUARE_SIZE: Dp = 30.dp
const val SQUARE_Animation_DELAY: Int = 500 // in milliseconds