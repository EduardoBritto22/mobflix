package com.alura.data.repository

import com.alura.data.repository.datasource.ILocalDataSource
import com.alura.domain.model.VideoModel
import com.alura.domain.repository.IVideosRepository
import com.alura.data.db.entity.VideoEntity
import com.alura.data.mapper.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideosRepositoryImpl @Inject constructor(
    private val localDataSource: ILocalDataSource,
    private val mapper: Mapper<VideoEntity, VideoModel>
) : IVideosRepository {

    override fun getVideos(): Flow<List<VideoModel>> {
        return localDataSource.getVideos().map { videoList -> videoList.map(mapper::mapFromEntity) }
    }

    override suspend fun saveVideo(video: VideoModel) {
        localDataSource.saveVideo(mapper.mapToEntity(video))
    }

    override suspend fun updateVideo(video: VideoModel) {
        localDataSource.updateVideo(mapper.mapToEntity(video))
    }

    override suspend fun deleteVideo(video: VideoModel) {
        localDataSource.deleteVideo(mapper.mapToEntity(video))
    }

    override fun getVideoById(id: Int): Flow<VideoModel> {
        return localDataSource.getVideoById(id).map(mapper::mapFromEntity)
    }
}