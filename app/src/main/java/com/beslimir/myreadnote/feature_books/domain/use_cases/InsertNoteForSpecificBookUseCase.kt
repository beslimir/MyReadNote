package com.beslimir.myreadnote.feature_books.domain.use_cases

import com.beslimir.myreadnote.feature_books.data.local.entities.NoteEntity
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository

class InsertNoteForSpecificBookUseCase (
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(note: NoteEntity) {
        mainRepository.insertNoteForSpecificBook(note)
    }
}