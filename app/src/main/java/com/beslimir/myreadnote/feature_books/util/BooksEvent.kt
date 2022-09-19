package com.beslimir.myreadnote.feature_books.util

import androidx.compose.ui.focus.FocusState

sealed class BooksEvent {
    data class EnteredBookTitle(val value: String): BooksEvent()
    data class ChangeTitleFocus(val focusState: FocusState): BooksEvent()
    data class EnteredBookAuthor(val value: String): BooksEvent()
    data class ChangeAuthorFocus(val focusState: FocusState): BooksEvent()
    data class EnteredBookType(val value: String): BooksEvent()
    data class ChangeBookTypeFocus(val focusState: FocusState): BooksEvent()
    data class Order(val orderCategory: OrderCategory): BooksEvent()
    object SaveNewBook: BooksEvent()
}
