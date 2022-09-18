package com.beslimir.myreadnote.feature_books.presentation.books

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.beslimir.myreadnote.ui.theme.RedOrange
import androidx.compose.ui.unit.dp
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity

@Composable
fun BookListItem(
    bookEntity: BookEntity,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(RedOrange)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Text(text = bookEntity.bookTitle)
                Text(text = bookEntity.bookAuthor)
                Text(text = "${bookEntity.bookStartDate}")
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}