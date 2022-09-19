package com.beslimir.myreadnote.feature_books.presentation.books

data class BookSectionItemState(
    val header: String = "",
    val inputValue: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
