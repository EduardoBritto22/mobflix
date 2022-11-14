package com.alura.data.di

import com.alura.data.repository.VideosRepositoryImpl
import com.alura.domain.repository.IVideosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIVideosRepository(
        videosRepositoryImpl: VideosRepositoryImpl
    ): IVideosRepository

}