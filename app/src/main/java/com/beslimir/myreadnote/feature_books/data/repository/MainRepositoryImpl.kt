package com.beslimir.myreadnote.feature_books.data.repository

import com.beslimir.myreadnote.feature_books.data.local.MainDao
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val mainDao: MainDao,
) : MainRepository {

    override suspend fun insertBook(book: BookEntity) {
        mainDao.insertBook(book)
    }

    override suspend fun insertNoteForSpecificBook(note: NoteEntity) {
        mainDao.insertNoteForSpecificBook(note)
    }

    override fun getAllBooks(): Flow<Resource<List<BookEntity>>> {
        return flow {
            val booksList = mainDao.getAllBooks()
            emit(Resource.Success(
                data = booksList
            ))
        }
    }

    override fun getAllNotesForSpecificBook(bookId: Int): Flow<Resource<List<BookWithNotes>>> {
        return flow {
            val notesLIst = mainDao.getAllNotesForSpecificBook(bookId)
            emit(Resource.Success(
                data = notesLIst
            ))
        }
    }
}