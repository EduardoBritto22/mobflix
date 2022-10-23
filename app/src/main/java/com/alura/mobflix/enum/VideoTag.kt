package com.alura.mobflix.enum

import androidx.compose.ui.graphics.Color
import com.alura.mobflix.ui.theme.BlueTag
import com.alura.mobflix.ui.theme.GreenTag
import com.alura.mobflix.ui.theme.RedTag

enum class VideoTag(val tagName: String,val color: Color) {

    MOBILE("Mobile", RedTag),
    PROGRAMMING("Programming", GreenTag),
    FRONT_ENT("Front End", BlueTag)

}