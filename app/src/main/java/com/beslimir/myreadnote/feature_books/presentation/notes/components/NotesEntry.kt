package com.beslimir.myreadnote.feature_books.presentation.notes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesViewModel

@Composable
fun NotesEntry(
    entry: NoteEntity,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = hiltViewModel()
) {
    Box(
        modifier = modifier
            .shadow(
                5.dp,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .clickable {
                //TODO: Implement clickable action
            },
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = entry.noteTitle ?: "No title",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = entry.noteContent,
                maxLines = 5
            )
        }
    }
}