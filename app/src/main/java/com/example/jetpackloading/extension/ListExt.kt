package com.example.jetpackloading.extension

fun <T> List<T>.mirror(): List<T> {
    var mirroredList = listOf<T>()
    if (this.size.isOdd()) {
        mirroredList = this.toMutableList()
        val reversedPart = this.subList(0, size - 1).reversed()
        mirroredList.addAll(reversedPart)
    } else {
        mirroredList = this.toMutableList()
        val reversedPart = this.reversed()
        mirroredList.addAll(reversedPart)
    }
    return mirroredList
}