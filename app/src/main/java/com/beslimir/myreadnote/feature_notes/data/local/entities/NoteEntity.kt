package com.beslimir.myreadnote.feature_notes.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey val noteId: Int,
    val noteTitle: String? = null,
    val noteContent: String
)
