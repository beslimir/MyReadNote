package com.beslimir.myreadnote.feature_books.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.domain.use_cases.UseCaseWrapper
import com.beslimir.myreadnote.feature_books.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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

    private var getAllNotesJob: Job? = null
    private var currentBookId: Int = -1

    init {
        savedStateHandle.get<Int>("bookId")?.let { bookId ->
            if (bookId != -1) {
                currentBookId = bookId
                getAllNotesForASpecificBook(bookId)
            }
        }
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
            is NotesEvent.SaveNewNote -> {
                viewModelScope.launch(Dispatchers.IO) {
                    useCases.insertNoteForSpecificBookUseCase(
                        NoteEntity(
                            noteTitle = noteTitle.value.inputValue,
                            noteContent = noteDescription.value.inputValue,
                            bookId = currentBookId
                        )
                    )
                    //TODO: get all notes
                    closeNewNotesSection()
                }
            }

        }
    }

    private fun getAllNotesForASpecificBook(bookId: Int) {
        getAllNotesJob?.cancel()
        getAllNotesJob = useCases.getAllNotesForSpecificBookUseCase(bookId).onEach { result ->
            when (result) {
                is Resource.Error -> {}
                is Resource.Loading -> Unit
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        notesList = result.data!![0].notes
                    )
                }
            }
        }.launchIn(viewModelScope)
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