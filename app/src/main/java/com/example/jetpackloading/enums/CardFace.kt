package com.example.jetpackloading.enums

enum class CardFace(val angle: Float, val axis: RotationAxis) {
    AxisX(angle = 180f, axis = RotationAxis.AxisX) {
        override val next: CardFace
            get() = AxisY
    },
    AxisY(angle = 180f, axis = RotationAxis.AxisY) {
        override val next: CardFace
            get() = AxisX
    };

    abstract val next: CardFace
}