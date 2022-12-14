package com.beslimir.myreadnote.feature_books.presentation.books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.domain.use_cases.UseCaseWrapper
import com.beslimir.myreadnote.feature_books.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val useCases: UseCaseWrapper,
) : ViewModel() {

    private val _state = mutableStateOf(BooksState())
    val state: State<BooksState> = _state

    private val _bookTitle = mutableStateOf(BookSectionItemState(
        header = "Book title",
        hint = "Enter book title"
    ))
    val bookTitle: State<BookSectionItemState> = _bookTitle

    private val _bookAuthor = mutableStateOf(BookSectionItemState(
        header = "Book author",
        hint = "Enter book author"
    ))
    val bookAuthor: State<BookSectionItemState> = _bookAuthor

    private val _bookType = mutableStateOf(BookSectionItemState(
        header = "Book type",
        hint = "",
        inputValue = BookType.ADVENTURE.name
    ))
    val bookType: State<BookSectionItemState> = _bookType

    private var getAllBooksJob: Job? = null

    init {
//        insertNewBook(
//            BookEntity(
//                bookId = 1,
//                bookTitle = "Budni u 5",
//                bookAuthor = "Robin Sharma",
//                5000000L,
//                bookEndDate = null,
//                bookRate = -1,
//                BookType.SELF_DEVELOPMENT
//            )
//        )
//
//        insertNoteForSpecificBook(
//            NoteEntity(
//                noteTitle = "Second Note",
//                noteContent = "This is the content of the second note.",
//                bookId = 1
//            )
//        )

        getAllBooks(OrderCategory.Date(OrderType.DESCENDING))
    }

    fun onEvent(event: BooksEvent) {
        when (event) {
            is BooksEvent.Order -> {

            }
            is BooksEvent.SaveNewBook -> {
                viewModelScope.launch(Dispatchers.IO) {
                    useCases.insertBookUseCase(
                        BookEntity(
                            bookTitle = bookTitle.value.inputValue,
                            bookAuthor = bookAuthor.value.inputValue,
                            bookStartDate = 500000L, //TODO: import real time
                            bookType = BookType.valueOf(bookType.value.inputValue)
                        )
                    )
                    getAllBooks(OrderCategory.Date(OrderType.DESCENDING))
                    closeNewBookSection()
                }
            }
            is BooksEvent.OpenBookSection -> {
                openNewBookSection()
            }
            is BooksEvent.CloseBookSection -> {
                closeNewBookSection()
            }
            is BooksEvent.EnteredBookTitle -> {
                _bookTitle.value = bookTitle.value.copy(
                    inputValue = event.value
                )
            }
            is BooksEvent.EnteredBookAuthor -> {
                _bookAuthor.value = bookAuthor.value.copy(
                    inputValue = event.value
                )
            }
            is BooksEvent.ChangeTitleFocus -> {
                _bookTitle.value = bookTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused
                            && bookTitle.value.inputValue.isBlank()
                )
            }
            is BooksEvent.ChangeAuthorFocus -> {
                _bookAuthor.value = bookAuthor.value.copy(
                    isHintVisible = !event.focusState.isFocused
                            && bookAuthor.value.inputValue.isBlank()
                )
            }
            is BooksEvent.SelectBookType -> {
                _bookType.value = bookType.value.copy(
                    inputValue = event.value.name
                )
            }
            is BooksEvent.ClearTitleInput -> {
                _bookTitle.value = bookTitle.value.copy(
                    inputValue = ""
                )
            }
            is BooksEvent.ClearAuthorInput -> {
                _bookAuthor.value = bookAuthor.value.copy(
                    inputValue = ""
                )
            }
        }
    }

    private fun openNewBookSection() {
        _state.value = state.value.copy(
            isNewBookSectionVisible = true
        )
    }

    private fun closeNewBookSection() {
        _state.value = state.value.copy(
            isNewBookSectionVisible = false
        )
        _bookTitle.value = bookTitle.value.copy(
            inputValue = ""
        )
        _bookAuthor.value = bookAuthor.value.copy(
            inputValue = ""
        )
    }

    private fun insertNoteForSpecificBook(noteEntity: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.insertNoteForSpecificBookUseCase(noteEntity)
        }
    }

    private fun getAllBooks(orderCategory: OrderCategory) {
        getAllBooksJob?.cancel()
        getAllBooksJob = useCases.getAllBooksUseCase(orderCategory).onEach { result ->
            when (result) {
                is Resource.Error -> {}
                is Resource.Loading -> Unit
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        books = result.data!!
                    )
                }
            }

        }.launchIn(viewModelScope)
    }
}