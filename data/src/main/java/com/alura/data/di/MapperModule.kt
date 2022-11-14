package com.alura.data.di

import com.alura.data.db.entity.VideoEntity
import com.alura.data.mapper.Mapper
import com.alura.data.mapper.VideoMapper
import com.alura.domain.model.VideoModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindMapper(
        mapper: VideoMapper
    ): Mapper<VideoEntity, VideoModel>

}