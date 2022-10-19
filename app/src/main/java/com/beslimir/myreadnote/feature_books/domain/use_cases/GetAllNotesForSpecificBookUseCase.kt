package com.beslimir.myreadnote.feature_books.domain.use_cases

import com.beslimir.myreadnote.feature_books.data.local.entities.BookWithNotes
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.util.OrderCategory
import com.beslimir.myreadnote.feature_books.util.OrderType
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllNotesForSpecificBookUseCase(
    private val mainRepository: MainRepository,
) {
    operator fun invoke(
        bookId: Int,
        orderCategory: OrderCategory = OrderCategory.Date(OrderType.DESCENDING)
    ): Flow<Resource<BookWithNotes>> {
        //TODO: Implement order category
        return mainRepository.getAllNotesForSpecificBook(bookId).map {
            try {
                Resource.Success(it)
            } catch (e: Exception) {
                Resource.Error(message = e.message.toString())
            }
        }
    }
}