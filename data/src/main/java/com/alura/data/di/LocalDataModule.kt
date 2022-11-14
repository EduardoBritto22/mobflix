package com.alura.data.di

import com.alura.data.repository.datasource.ILocalDataSource
import com.alura.data.repository.datasourceimpl.LocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataModule {

    @Singleton
    @Binds
    abstract fun bindILocalDataSource(
        localDataSource: LocalDataSource
    ): ILocalDataSource
}