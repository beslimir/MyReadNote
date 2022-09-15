package com.beslimir.myreadnote.feature_books.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class BookWithNotes(
    @Embedded val bookEntity: BookEntity,
    @Relation(
        parentColumn = "bookId",
        entityColumn = "bookId"
    )
    val notes: List<NoteEntity>
)
