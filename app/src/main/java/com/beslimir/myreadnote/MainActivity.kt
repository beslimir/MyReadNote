package com.beslimir.myreadnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beslimir.myreadnote.feature_books.presentation.Screen
import com.beslimir.myreadnote.feature_books.presentation.books.BooksScreen
import com.beslimir.myreadnote.ui.theme.MyReadNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyReadNoteTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.BooksScreen.route
                ) {
                    composable(route = Screen.BooksScreen.route) {
                        BooksScreen(navController = navController)
                    }
                }
            }
        }
    }
}