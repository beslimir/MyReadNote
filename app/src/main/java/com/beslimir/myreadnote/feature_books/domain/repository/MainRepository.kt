package com.beslimir.myreadnote.feature_books.domain.repository

import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun insertBook(book: BookEntity)
    suspend fun insertNoteForSpecificBook(note: NoteEntity)

    fun getAllBooks(): Flow<Resource<List<BookEntity>>>
    fun getAllNotesForSpecificBook(bookId: Int): Flow<List<BookWithNotes>>

}