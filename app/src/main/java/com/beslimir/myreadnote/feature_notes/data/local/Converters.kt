package com.beslimir.myreadnote.feature_notes.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.beslimir.myreadnote.feature_notes.util.BookType

@ProvidedTypeConverter
class Converters {

    @TypeConverter
    fun fromBookType(bookType: BookType) = bookType.name

    @TypeConverter
    fun toBookType(string: String) = enumValueOf<BookType>(string)

}