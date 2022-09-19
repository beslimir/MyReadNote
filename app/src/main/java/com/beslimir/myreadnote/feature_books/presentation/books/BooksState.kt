package com.beslimir.myreadnote.feature_books.presentation.books

import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.util.OrderCategory
import com.beslimir.myreadnote.feature_books.util.OrderType

data class BooksState(
    val books: List<BookEntity> = emptyList(),
    val bookOrderType: OrderCategory = OrderCategory.Date(OrderType.DESCENDING),
    val isNewBookSectionVisible: Boolean = false
)
