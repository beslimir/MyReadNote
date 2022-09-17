package com.beslimir.myreadnote.feature_books.presentation.books

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity

@Composable
fun BookListItem(
    bookEntity: BookEntity,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = bookEntity.bookTitle)
        Text(text = bookEntity.bookAuthor)
        Text(text = bookEntity.bookStartDate.toString())
    }
}