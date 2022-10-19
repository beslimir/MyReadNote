package com.beslimir.myreadnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.beslimir.myreadnote.feature_books.presentation.Screen
import com.beslimir.myreadnote.feature_books.presentation.books.BooksEvent
import com.beslimir.myreadnote.feature_books.presentation.books.BooksScreen
import com.beslimir.myreadnote.feature_books.presentation.books.BooksViewModel
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesEvent
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesScreen
import com.beslimir.myreadnote.feature_books.presentation.notes.NotesViewModel
import com.beslimir.myreadnote.ui.theme.MyReadNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var booksViewModel: BooksViewModel
    private lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyReadNoteTheme {
                booksViewModel = hiltViewModel()
                notesViewModel = hiltViewModel()

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.BooksScreen.route
                ) {
                    composable(route = Screen.BooksScreen.route) {
                        BooksScreen(
                            navController = navController,
                            viewModel = booksViewModel
                        )
                    }
                    composable(
                        route = Screen.NotesScreen.route + "?bookId={bookId}",
                        arguments = listOf(
                            navArgument(name = "bookId") {
                                type = NavType.IntType
                                defaultValue = -1
                            })
                    ) {
                        NotesScreen(
                            navController = navController
                        )
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (booksViewModel.state.value.isNewBookSectionVisible) {
            booksViewModel.onEvent(BooksEvent.CloseBookSection)
        }
//        else if (notesViewModel.state.value.isNewNoteSectionVisible) {
//            notesViewModel.onEvent(NotesEvent.CloseNewNotesSection)
//        }
        else {
            super.onBackPressed()
        }
    }
}