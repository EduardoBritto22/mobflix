package com.alura.mobflix.util

import android.util.Patterns
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