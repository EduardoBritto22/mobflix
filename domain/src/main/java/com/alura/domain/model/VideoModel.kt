package com.alura.domain.model

import com.alura.domain.enums.VideoCategory

data class VideoModel(
    var id: Int,
    var url: String,
    var category: VideoCategory
)
