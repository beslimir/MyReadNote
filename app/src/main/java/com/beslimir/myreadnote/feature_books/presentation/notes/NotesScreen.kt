package com.beslimir.myreadnote.feature_books.presentation.notes

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val bookTitleState = viewModel.bookTitle.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Default.NoteAdd,
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

            }
        }
    }
}