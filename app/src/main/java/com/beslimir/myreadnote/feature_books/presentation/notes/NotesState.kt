package com.beslimir.myreadnote.feature_books.presentation.notes

import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.util.OrderCategory
import com.beslimir.myreadnote.feature_books.util.OrderType

data class NotesState(
    val notesList: List<NoteEntity> = emptyList(),
    val notesOrderType: OrderCategory = OrderCategory.Date(OrderType.DESCENDING),
    val isNewNoteSectionVisible: Boolean = false
)