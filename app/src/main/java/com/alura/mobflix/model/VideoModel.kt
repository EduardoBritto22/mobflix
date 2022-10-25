package com.alura.mobflix.model

import com.alura.mobflix.enum.VideoTag

data class VideoModel(
    val url: String,
    val category: VideoTag
)
