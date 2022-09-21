package com.beslimir.myreadnote.feature_books.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.beslimir.myreadnote.feature_books.domain.use_cases.UseCaseWrapper
import com.beslimir.myreadnote.feature_books.presentation.books.BooksState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCases: UseCaseWrapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private val _bookTitle = mutableStateOf("My book")
    val bookTitle: State<String> = _bookTitle

    private var currentBookId: Int = -1

    init {
//        savedStateHandle.get<Int>("bookId")?.let { bookId ->
//            if (bookId != -1) {
//                viewModelScope.launch {
//                    useCases.getAllNotesForSpecificBookUseCase(bookId).also {
//
//                    }
//                }
//            }
//        }
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.OpenNewNotesSection -> {
                openNewNotesSection()
            }
            is NotesEvent.CloseNewNotesSection -> {
                closeNewNotesSection()
            }
        }
    }

    private fun openNewNotesSection() {
        _state.value = state.value.copy(
            isNewNoteSectionVisible = true
        )
    }

    private fun closeNewNotesSection() {
        _state.value = state.value.copy(
            isNewNoteSectionVisible = true
        )
    }

}