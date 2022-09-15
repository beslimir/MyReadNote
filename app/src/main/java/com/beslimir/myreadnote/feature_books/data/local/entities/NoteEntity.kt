package com.beslimir.myreadnote.feature_books.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey val noteId: Int,
    val noteTitle: String? = null,
    val noteContent: String,
    val bookId: Int
)
