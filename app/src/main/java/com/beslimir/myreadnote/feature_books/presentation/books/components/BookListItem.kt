package com.beslimir.myreadnote.feature_books.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity.Companion.bookItemColors

@Composable
fun BookListItem(
    bookEntity: BookEntity,
) {
    val colorCode = bookEntity.bookType.colorCode
    val color: Color = bookItemColors[colorCode]

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Text(
                    text = bookEntity.bookTitle,
                    style = MaterialTheme.typography.h6,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Text(
                    text = bookEntity.bookAuthor,
                    style = MaterialTheme.typography.body2,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
                Text(
                    text = "${bookEntity.bookStartDate}",
                    style = MaterialTheme.typography.body2,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Thin,
                    fontStyle = FontStyle.Italic,
                    color = Color.DarkGray
                )
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