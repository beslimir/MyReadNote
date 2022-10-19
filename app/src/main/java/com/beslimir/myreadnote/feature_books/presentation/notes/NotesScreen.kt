package com.beslimir.myreadnote.feature_books.presentation.notes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.beslimir.myreadnote.feature_books.presentation.notes.components.NewNoteSection
import com.beslimir.myreadnote.feature_books.presentation.notes.components.NotesRow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val bookTitleState = viewModel.bookTitle.value
    val state = viewModel.state.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(NotesEvent.OpenNewNotesSection)
            }) {
                Icon(
                    imageVector = Icons.Default.NoteAlt,
                    contentDescription = "Add new note"
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = bookTitleState,
                        style = MaterialTheme.typography.h6,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Notes",
                        style = MaterialTheme.typography.body2,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Medium
                    )
                }
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings"
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            state.bookWithNotes?.let {
                                val notesCount = if (state.bookWithNotes.notes.size % 2 == 0) {
                                    state.bookWithNotes.notes.size / 2
                                } else {
                                    state.bookWithNotes.notes.size / 2 + 1
                                }
                                items(notesCount) {
                                    NotesRow(
                                        rowIndex = it,
                                        entry = state.bookWithNotes,
                                        navController = navController
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AnimatedVisibility(
                            visible = state.isNewNoteSectionVisible,
                            enter = expandIn(),
                            exit = shrinkOut()
                        ) {
                            NewNoteSection(bookTitle = bookTitleState)
                        }
                    }
                }
            }
        }
    }
}