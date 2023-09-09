package com.example.jetpackloading.ui.theme.loading_component.lineScaleIndicator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.jetpackloading.ANIMATION_DEFAULT_COLOR
import com.example.jetpackloading.enums.PunchType

@Composable
fun LineScaleIndicator(
    color: Color = ANIMATION_DEFAULT_COLOR,
    rectCount: Int = 5,
    punchType: PunchType
) {
    when(punchType) {
        PunchType.RANDOM_PUNCH -> LineScalePartyIndicator(color, rectCount)
        PunchType.ACCORDION_PUNCH -> SimpleLineScaleIndicator(color, rectCount)
        PunchType.PULSE_OUT_PUNCH -> LineScalePulseOutIndicator(color, rectCount)
    }
}