package com.alura.data.db

import androidx.room.*
import com.alura.data.db.entity.VideoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VideosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addVideo(video: VideoEntity)
    @Update
    suspend fun updateVideo(video: VideoEntity)
    @Delete
    suspend fun deleteVideo(video: VideoEntity)
    @Query("SELECT * FROM videos")
    fun getAllVideos():Flow<List<VideoEntity>>
    @Query("SELECT * FROM videos WHERE id = :id")
    fun getVideoById(id: Int):Flow<VideoEntity>
}