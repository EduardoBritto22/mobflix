package com.alura.mobflix.util

import android.util.Patterns
import androidx.compose.ui.graphics.Color
import com.alura.domain.enums.VideoCategory
import com.alura.mobflix.ui.theme.*
import java.net.URI

fun getAValidYoutubePath(url: String): String {
    val matcher = Patterns.WEB_URL.matcher(url)

    val validUrl = if (matcher.matches()) {
        val uri = URI(url)
        uri.path.removePrefix("/")
    } else {
        url
    }
    return validUrl
}


fun getCategoryColor(category: VideoCategory): Color {
    return when(category){
        VideoCategory.MOBILE -> RedTag
        VideoCategory.PROGRAMMING -> GreenTag
        VideoCategory.FRONT_ENT -> BlueTag
        VideoCategory.DATA_SCIENCE -> LightGreenTag
        VideoCategory.DEVOPS -> YellowTag
        VideoCategory.UX_DESIGN -> PinkTag
    }
}