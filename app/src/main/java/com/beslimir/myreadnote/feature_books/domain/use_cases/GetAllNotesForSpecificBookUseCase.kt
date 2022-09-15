package com.beslimir.myreadnote.feature_books.domain.use_cases

import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllNotesForSpecificBookUseCase(
    private val mainRepository: MainRepository,
) {
    operator fun invoke(bookId: Int): Flow<Resource<List<BookWithNotes>>> {
        return mainRepository.getAllNotesForSpecificBook(bookId)
    }
}