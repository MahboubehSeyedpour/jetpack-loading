package com.spr.jetpack_loading.enums

enum class SwapSpinStates(
    val xStartCoe: Int, // X-axis StartCoefficient
    val yStartCoe: Int, // Y-axis StartCoefficient
    val xEndCoe: Int,  // X-axis End Coefficient
    val yEndCoe: Int // Y-axis End Coefficient
) {
    TO_UP(
        xStartCoe = -1,
        yStartCoe = 1,
        xEndCoe = -1,
        yEndCoe = -1
    ) {
        override val next: SwapSpinStates
            get() = UP_TO_STAY
    },
    UP_TO_STAY(
        xStartCoe = -1,
        yStartCoe = -1,
        xEndCoe = -1,
        yEndCoe = -1
    ) {
        override val next: SwapSpinStates
            get() = STAY_TO_RIGHT
    },
    STAY_TO_RIGHT(
        xStartCoe = -1,
        yStartCoe = -1,
        xEndCoe = -1,
        yEndCoe = -1
    ) {
        override val next: SwapSpinStates
            get() = TO_RIGHT
    },
    TO_RIGHT(
        xStartCoe = -1,
        yStartCoe = -1,
        xEndCoe = 1,
        yEndCoe = -1
    ) {
        override val next: SwapSpinStates
            get() = RIGHT_TO_STAY
    },
    RIGHT_TO_STAY(
        xStartCoe = 1,
        yStartCoe = -1,
        xEndCoe = 1,
        yEndCoe = -1
    ) {
        override val next: SwapSpinStates
            get() = STAY_TO_BOTTOM
    },
    STAY_TO_BOTTOM(
        xStartCoe = 1,
        yStartCoe = -1,
        xEndCoe = 1,
        yEndCoe = -1
    ) {
        override val next: SwapSpinStates
            get() = TO_BOTTOM
    },
    TO_BOTTOM(
        xStartCoe = 1,
        yStartCoe = -1,
        xEndCoe = 1,
        yEndCoe = 1
    ) {
        override val next: SwapSpinStates
            get() = BOTTOM_TO_STAY
    },
    BOTTOM_TO_STAY(
        xStartCoe = 1,
        yStartCoe = 1,
        xEndCoe = 1,
        yEndCoe = 1
    ) {
        override val next: SwapSpinStates
            get() = STAY_TO_LEFT
    },
    STAY_TO_LEFT(
        xStartCoe = 1,
        yStartCoe = 1,
        xEndCoe = 1,
        yEndCoe = 1
    ) {
        override val next: SwapSpinStates
            get() = TO_LEFT
    },
    TO_LEFT(
        xStartCoe = 1,
        yStartCoe = 1,
        xEndCoe = -1,
        yEndCoe = 1
    ) {
        override val next: SwapSpinStates
            get() = LEFT_TO_STAY
    },
    LEFT_TO_STAY(
        xStartCoe = -1,
        yStartCoe = 1,
        xEndCoe = -1,
        yEndCoe = 1
    ) {
        override val next: SwapSpinStates
            get() = STAY_TO_UP
    },
    STAY_TO_UP(
        xStartCoe = -1,
        yStartCoe = 1,
        xEndCoe = -1,
        yEndCoe = 1
    ) {
        override val next: SwapSpinStates
            get() = TO_UP
    };

    abstract val next: SwapSpinStates
}