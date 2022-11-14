package com.alura.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alura.data.db.entity.VideoEntity

@Database(entities = [VideoEntity::class], version = 1)
abstract class VideoDatabase: RoomDatabase() {
    abstract fun videosDao(): VideosDao
}