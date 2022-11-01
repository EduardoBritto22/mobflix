package com.alura.mobflix.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alura.mobflix.data.db.entity.VideoEntity
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
    suspend fun getAllVideos():Flow<List<VideoEntity>>
}