package com.beslimir.myreadnote.feature_books.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beslimir.myreadnote.ui.theme.*

@Entity
data class NoteEntity(
    @PrimaryKey val noteId: Int? = null,
    val noteTitle: String? = null,
    val noteContent: String,
    val bookId: Int
) {
    companion object {
        val bookItemColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
