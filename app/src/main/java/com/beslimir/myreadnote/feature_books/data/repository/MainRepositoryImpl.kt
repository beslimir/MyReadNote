package com.beslimir.myreadnote.feature_books.data.repository

import com.beslimir.myreadnote.feature_books.data.local.MainDatabase
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    mainDatabase: MainDatabase
) : MainRepository {

    private val mainDao = mainDatabase.dao

    override suspend fun insertBook(book: BookEntity) {
        mainDao.insertBook(book)
    }

    override suspend fun insertNoteForSpecificBook(note: NoteEntity) {
        mainDao.insertNoteForSpecificBook(note)
    }

    override fun getAllBooks(): Flow<Resource<List<BookEntity>>> = flow {
        try {
            val bookList = mainDao.getAllBooks()
            emit(Resource.Success(bookList))
        } catch (e: Exception) {
            emit(Resource.Error(
                message = e.message ?: "An error occurred."
            ))
        }
    }

    override fun getAllNotesForSpecificBook(bookId: Int): Flow<BookWithNotes> {
        return flow {
            val notesList = mainDao.getAllNotesForSpecificBook(bookId)
            emit(notesList)
        }
    }
}