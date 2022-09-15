package com.beslimir.myreadnote.feature_books.domain.use_cases

import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository

class InsertBookUseCase(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(book: BookEntity) {
        mainRepository.insertBook(book)
    }
}