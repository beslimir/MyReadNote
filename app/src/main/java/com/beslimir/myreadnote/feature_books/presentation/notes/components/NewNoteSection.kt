package com.beslimir.myreadnote.feature_books.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesEvent
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesViewModel
import com.beslimir.myreadnote.ui.theme.DarkGray
import com.beslimir.myreadnote.ui.theme.RedOrange

@Composable
fun NewNoteSection(
    bookTitle: String,
    viewModel: NotesViewModel = hiltViewModel(),
) {

    val noteTitle = viewModel.noteTitle.value
    val noteDescription = viewModel.noteDescription.value

    Box {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .clickable {

                },
            color = DarkGray.copy(alpha = 0.75f)
        ) {}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(5.dp))
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(5.dp)
                )
                .background(RedOrange)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp),
                contentAlignment = Alignment.TopStart
            ) {
                if (noteTitle.isHintVisible) {
                    Text(
                        text = noteTitle.hint,
                        style = MaterialTheme.typography.h6,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
                BasicTextField(
                    value = noteTitle.inputValue,
                    onValueChange = {
                        viewModel.onEvent(NotesEvent.EnterNoteTitle(it))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            viewModel.onEvent(NotesEvent.ChangeTitleFocus(it))
                        },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.h6.copy(
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    cursorBrush = SolidColor(Color.White)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
                    .weight(1f)
            ) {
                if (noteDescription.isHintVisible) {
                    Text(
                        text = noteDescription.hint,
                        style = MaterialTheme.typography.body2
                    )
                }
                BasicTextField(
                    value = noteDescription.inputValue,
                    onValueChange = {
                        viewModel.onEvent(NotesEvent.EnterNoteDescription(it))
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .onFocusChanged {
                            viewModel.onEvent(NotesEvent.ChangeDescriptionFocus(it))
                        },
                    textStyle = MaterialTheme.typography.body2.copy(
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    cursorBrush = SolidColor(Color.White)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {}
                    ), //make window non clickable and without ripple effect
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    viewModel.onEvent(NotesEvent.CloseNewNotesSection)
                }) {
                    Text(
                        text = "Cancel",
                        color = DarkGray
                    )
                }
                Button(onClick = {
                    viewModel.onEvent(NotesEvent.SaveNewNote)
                }) {
                    Text(
                        text = "Save",
                        color = DarkGray
                    )
                }
            }
        }
    }
}