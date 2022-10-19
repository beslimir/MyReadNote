package com.beslimir.myreadnote.feature_books.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesViewModel

@Composable
fun NotesEntry(
    entry: BookWithNotes,
    index: Int,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = hiltViewModel(),
) {
    val colorCode = entry.bookEntity.bookType.colorCode
    val color: Color = NoteEntity.bookItemColors[colorCode]

    Box(
        modifier = modifier
            .shadow(
                5.dp,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(color)
            .clickable {
                //TODO: Implement clickable action
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = entry.notes[index].noteTitle ?: "No title",
                style = MaterialTheme.typography.h6,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = entry.notes[index].noteContent,
                style = MaterialTheme.typography.body2,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}