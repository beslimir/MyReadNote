package com.beslimir.myreadnote.feature_notes.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.beslimir.myreadnote.feature_notes.data.local.entities.BookWithNotes

@Dao
interface ReadNoteDao {

    @Transaction //execute in a thread safe manner
    @Query("SELECT * FROM BookEntity WHERE bookId = :bookId")
    suspend fun getBookWithNotes(bookId: Int): List<BookWithNotes>

}