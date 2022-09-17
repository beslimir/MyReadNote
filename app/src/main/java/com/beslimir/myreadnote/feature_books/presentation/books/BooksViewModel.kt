package com.beslimir.myreadnote.feature_books.presentation.books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.domain.use_cases.UseCaseWrapper
import com.beslimir.myreadnote.feature_books.util.BookType
import com.beslimir.myreadnote.feature_books.util.OrderCategory
import com.beslimir.myreadnote.feature_books.util.OrderType
import com.beslimir.myreadnote.feature_books.util.Resource
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

    private fun insertNewBook(bookEntity: BookEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.insertBookUseCase(bookEntity)
        }
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