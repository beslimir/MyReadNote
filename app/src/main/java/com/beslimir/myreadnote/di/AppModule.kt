package com.beslimir.myreadnote.di

import android.app.Application
import androidx.room.Room
import com.beslimir.myreadnote.feature_books.data.local.Converters
import com.beslimir.myreadnote.feature_books.data.local.MainDatabase
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainDatabase(app: Application): MainDatabase {
        return Room.databaseBuilder(
            app,
            MainDatabase::class.java,
            "main_database.db"
        ).addTypeConverter(Converters()).build()
    }

    @Singleton
    @Provides
    fun provideUseCaseWrapper(
        mainRepository: MainRepository,
    ): UseCaseWrapper {
        return UseCaseWrapper(
            insertBookUseCase = InsertBookUseCase(mainRepository),
            insertNoteForSpecificBookUseCase = InsertNoteForSpecificBookUseCase(mainRepository),
            getAllBooksUseCase = GetAllBooksUseCase(mainRepository),
            getAllNotesForSpecificBookUseCase = GetAllNotesForSpecificBookUseCase(mainRepository)
        )
    }

    /**
     * The provides method below is provided (bind) in the repository module
     * as an abstraction, and the constructor is injected in the Repository
     * **/
//    @Singleton
//    @Provides
//    fun provideMainRepository(db: MainDatabase): MainRepository {
//        return MainRepositoryImpl(db.dao)
//    }

}