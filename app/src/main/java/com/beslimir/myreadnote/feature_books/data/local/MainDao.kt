package com.beslimir.myreadnote.feature_books.data.local

import androidx.room.*
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNoteForSpecificBook(note: NoteEntity)

    @Query("SELECT * FROM BookEntity")
    suspend fun getAllBooks(): List<BookEntity>

    @Transaction //execute in a thread safe manner
    @Query("SELECT * FROM BookEntity WHERE bookId = :bookId")
    suspend fun getAllNotesForSpecificBook(bookId: Int): BookWithNotes

}