package com.alura.mobflix.domain.enum

import androidx.compose.ui.graphics.Color
import com.alura.mobflix.ui.theme.BlueTag
import com.alura.mobflix.ui.theme.GreenTag
import com.alura.mobflix.ui.theme.RedTag

enum class VideoCategory(val tagName: String, val color: Color) {

    MOBILE("Mobile", RedTag),
    PROGRAMMING("Programming", GreenTag),
    FRONT_ENT("Front End", BlueTag),
    DATA_SCIENCE("Data Science",Color.Yellow),
    DEVOPS("Devops",Color.Cyan),
    UX_DESIGN("UX & Design",Color.Magenta)

}