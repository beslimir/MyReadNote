package com.beslimir.myreadnote.feature_books.presentation.books

import androidx.lifecycle.ViewModel
import com.beslimir.myreadnote.feature_books.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val useCases: UseCaseWrapper
): ViewModel() {

}