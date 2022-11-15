package com.alura.data.mapper

import com.alura.data.db.entity.VideoEntity
import com.alura.domain.enums.VideoCategory
import com.alura.domain.model.VideoModel
import javax.inject.Inject

class VideoMapper @Inject constructor() : Mapper<VideoEntity, VideoModel> {
    override fun mapFromEntity(domainType: VideoEntity): VideoModel {
        return VideoModel(
            id = domainType.id,
            url = domainType.url,
            category = VideoCategory.fromName(domainType.category)
        )
    }

    override fun mapToEntity(dataType: VideoModel): VideoEntity {
        return VideoEntity(
            id = dataType.id,
            url = dataType.url,
            category = dataType.category.tagName
        )
    }
}