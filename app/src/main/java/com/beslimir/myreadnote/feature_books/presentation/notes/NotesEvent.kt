package com.beslimir.myreadnote.feature_books.presentation.notes

import androidx.compose.ui.focus.FocusState

sealed class NotesEvent {
    data class EnterNoteTitle(val value: String): NotesEvent()
    data class ChangeTitleFocus(val focusState: FocusState): NotesEvent()
    data class EnterNoteDescription(val value: String): NotesEvent()
    data class ChangeDescriptionFocus(val focusState: FocusState): NotesEvent()
    object OpenNewNotesSection: NotesEvent()
    object CloseNewNotesSection: NotesEvent()
}
