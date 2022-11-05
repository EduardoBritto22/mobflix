package com.alura.mobflix.di

import com.alura.mobflix.data.repository.VideosRepositoryImpl
import com.alura.mobflix.domain.repository.IVideosRepository
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