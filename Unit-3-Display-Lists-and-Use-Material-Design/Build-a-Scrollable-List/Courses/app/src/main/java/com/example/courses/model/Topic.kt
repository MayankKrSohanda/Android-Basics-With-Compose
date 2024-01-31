package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResource: Int,
    val availableCourses: Int,
    @DrawableRes val imageResource: Int
)