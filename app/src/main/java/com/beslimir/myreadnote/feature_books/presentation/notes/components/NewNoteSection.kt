package com.beslimir.myreadnote.feature_books.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beslimir.myreadnote.ui.theme.DarkGray
import com.beslimir.myreadnote.ui.theme.RedOrange

@Composable
fun NewNoteSection() {
    Box() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .clickable {

                },
            color = DarkGray.copy(alpha = 0.75f)
        ) {

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .background(RedOrange)
        ) {
            Text(text = "Title")
            Text(text = "Description")
        }
    }
}