package com.beslimir.myreadnote.feature_books.domain.use_cases

data class UseCaseWrapper(
    val insertBookUseCase: InsertBookUseCase,
    val insertNoteForSpecificBookUseCase: InsertNoteForSpecificBookUseCase,
    val getAllBooksUseCase: GetAllBooksUseCase,
    val getAllNotesForSpecificBookUseCase: GetAllNotesForSpecificBookUseCase
)