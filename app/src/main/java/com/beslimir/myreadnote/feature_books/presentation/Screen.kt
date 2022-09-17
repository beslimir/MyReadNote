package com.beslimir.myreadnote.feature_books.presentation

sealed class Screen(val route: String) {
    object BooksScreen: Screen("books_screen")
}
