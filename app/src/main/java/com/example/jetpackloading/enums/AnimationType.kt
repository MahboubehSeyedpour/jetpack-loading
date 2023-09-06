package com.example.jetpackloading.enums

enum class AnimationType(id: Int, val animDuration: Int, val circleDelay: Long) {
    CIRCULAR(1, 500, 100L),
    SKIP_AND_REPEAT(2, 250, 250L);
}