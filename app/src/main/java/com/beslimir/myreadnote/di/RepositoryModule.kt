package com.beslimir.myreadnote.di

import com.beslimir.myreadnote.feature_books.data.repository.MainRepositoryImpl
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
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
    abstract fun bindMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository

}