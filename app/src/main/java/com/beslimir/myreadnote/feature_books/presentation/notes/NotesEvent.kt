package com.beslimir.myreadnote.feature_books.presentation.notes

sealed class NotesEvent {
    object OpenNewNotesSection: NotesEvent()
    object CloseNewNotesSection: NotesEvent()
}
