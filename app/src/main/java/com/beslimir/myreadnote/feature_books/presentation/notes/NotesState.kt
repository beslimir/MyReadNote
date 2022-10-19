package com.beslimir.myreadnote.feature_books.presentation.notes

import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.util.OrderCategory
import com.beslimir.myreadnote.feature_books.util.OrderType

data class NotesState(
    val bookWithNotes: BookWithNotes? = null,
    val notesOrderType: OrderCategory = OrderCategory.Date(OrderType.DESCENDING),
    val isNewNoteSectionVisible: Boolean = false,
)
