package com.beslimir.myreadnote.feature_books.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.beslimir.myreadnote.feature_books.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCases: UseCaseWrapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private val _noteTitle = mutableStateOf(NotesSectionItemsState(
        hint = "Enter title if needed..."
    ))
    val noteTitle: State<NotesSectionItemsState> = _noteTitle

    private val _noteDescription = mutableStateOf(NotesSectionItemsState(
        hint = "Enter description content..."
    ))
    val noteDescription: State<NotesSectionItemsState> = _noteDescription

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
            is NotesEvent.EnterNoteTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    inputValue = event.value
                )
            }
            is NotesEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused
                            && noteTitle.value.inputValue.isBlank()
                )
            }
            is NotesEvent.EnterNoteDescription -> {
                _noteDescription.value = noteDescription.value.copy(
                    inputValue = event.value
                )
            }
            is NotesEvent.ChangeDescriptionFocus -> {
                _noteDescription.value = noteDescription.value.copy(
                    isHintVisible = !event.focusState.isFocused
                            && noteDescription.value.inputValue.isBlank()
                )
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