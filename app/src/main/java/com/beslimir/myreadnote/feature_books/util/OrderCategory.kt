package com.beslimir.myreadnote.feature_books.util

sealed class OrderCategory(val orderType: OrderType) {
    class Date(orderType: OrderType): OrderCategory(orderType)
    class Title(orderType: OrderType): OrderCategory(orderType)
    class BookType(orderType: OrderType): OrderCategory(orderType)
}
