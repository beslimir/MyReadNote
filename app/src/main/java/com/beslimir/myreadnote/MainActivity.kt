package com.beslimir.myreadnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.beslimir.myreadnote.feature_books.presentation.books.BooksViewModel
import com.beslimir.myreadnote.ui.theme.MyReadNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyReadNoteTheme {
                val myViewModel = hiltViewModel<BooksViewModel>()
            }
        }
    }
}