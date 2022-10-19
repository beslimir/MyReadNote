package com.beslimir.myreadnote.feature_books.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes

@Composable
fun NotesRow(
    rowIndex: Int,
    entry: BookWithNotes,
    navController: NavController,
) {
    Column {
        Row {
            NotesEntry(
                entry = entry,
                index = rowIndex * 2,
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (entry.notes.size >= rowIndex * 2 + 2) {
                NotesEntry(
                    entry = entry,
                    index = rowIndex * 2 + 1,
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}