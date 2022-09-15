package com.beslimir.myreadnote.feature_books.domain.use_cases

import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllNotesForSpecificBookUseCase (
    private val mainRepository: MainRepository
) {
    operator fun invoke(): Flow<Resource<List<BookEntity>>> {
        return flow {}
    }
}