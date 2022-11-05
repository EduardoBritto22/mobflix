package com.alura.mobflix.di

import android.app.Application
import androidx.room.Room
import com.alura.mobflix.data.db.VideoDatabase
import com.alura.mobflix.data.db.VideosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideVideoDatabase(app: Application): VideoDatabase =
        Room.databaseBuilder(app, VideoDatabase::class.java, "videos_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideVideosDao(videoDB: VideoDatabase): VideosDao = videoDB.videosDao()

}