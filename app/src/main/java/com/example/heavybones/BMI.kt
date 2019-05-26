package com.example.heavybones


enum class BMIType(val image: Int, val description: Int, val type: Int) {
    UNDERWEIGHT(R.drawable.underweight_img, R.string.underweight, R.string.underweight_title),
    NORMAL(R.drawable.normalweight_img, R.string.normal, R.string.normal_title),
    OVERWEIGHT(R.drawable.overweight_img, R.string.overweight, R.string.overweight_title),
    OBESE(R.drawable.obese_img, R.string.obese, R.string.obese_title)
}