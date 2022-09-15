package com.beslimir.myreadnote.feature_notes.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beslimir.myreadnote.feature_notes.util.BookType

@Entity
data class BookEntity(
    @PrimaryKey val bookId: Int,
    val bookTitle: String,
    val bookAuthor: String,
    val bookStartDate: Long,
    val bookEndDate: Long? = null,
    val bookRate: Int? = null,
    val bookType: BookType
)
