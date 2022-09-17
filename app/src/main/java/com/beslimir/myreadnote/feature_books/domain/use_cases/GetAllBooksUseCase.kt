package com.beslimir.myreadnote.feature_books.domain.use_cases

import com.beslimir.myreadnote.feature_books.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_books.domain.repository.MainRepository
import com.beslimir.myreadnote.feature_books.util.OrderCategory
import com.beslimir.myreadnote.feature_books.util.OrderType
import com.beslimir.myreadnote.feature_books.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllBooksUseCase(
    private val mainRepository: MainRepository,
) {
    operator fun invoke(
        orderCategory: OrderCategory = OrderCategory.Date(OrderType.DESCENDING),
    ): Flow<Resource<List<BookEntity>>> {
        return mainRepository.getAllBooks().map { it ->
            if (it is Resource.Success) {
                val bookList = it.data
                Resource.Success(
                    when (orderCategory.orderType) {
                        OrderType.DESCENDING -> {
                            when (orderCategory) {
                                is OrderCategory.Date -> bookList!!.sortedBy { it.bookStartDate }
                                is OrderCategory.Title -> bookList!!.sortedBy { it.bookTitle }
                                is OrderCategory.BookType -> bookList!!.sortedBy { it.bookType.name }
                            }
                        }
                        OrderType.ASCENDING -> {
                            when (orderCategory) {
                                is OrderCategory.Date -> bookList!!.sortedByDescending { it.bookStartDate }
                                is OrderCategory.Title -> bookList!!.sortedByDescending { it.bookTitle }
                                is OrderCategory.BookType -> bookList!!.sortedByDescending { it.bookType.name }
                            }
                        }
                    }
                )
            } else {
                //error message can't be null because in RepositoryImpl a value is granted
                Resource.Error(it.message!!)
            }
        }
    }
}