package com.alura.mobflix.data.mapper

import com.alura.mobflix.data.db.entity.VideoEntity
import com.alura.mobflix.domain.enum.VideoCategory
import com.alura.mobflix.domain.model.VideoModel
import javax.inject.Inject

class VideoMapper @Inject constructor() : Mapper<VideoEntity, VideoModel> {
    override fun mapFromEntity(domainType: VideoEntity): VideoModel {
        return VideoModel(
            url = domainType.url,
            category = VideoCategory.fromName(domainType.category)
        )
    }

    override fun mapToEntity(dataType: VideoModel): VideoEntity {
        return VideoEntity(
            id = 0,
            url = dataType.url,
            category = dataType.category.tagName
        )
    }
}