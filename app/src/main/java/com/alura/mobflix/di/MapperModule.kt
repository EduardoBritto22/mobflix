package com.alura.mobflix.di

import com.alura.mobflix.data.db.entity.VideoEntity
import com.alura.mobflix.data.mapper.Mapper
import com.alura.mobflix.data.mapper.VideoMapper
import com.alura.mobflix.domain.model.VideoModel
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