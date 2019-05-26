package com.example.heavybones


class Body(
    var mass: Double,
    var height: Double
) {

    fun calculateBMI(): Double {
        return (mass / (height * height))
    }

}