package com.beslimir.myreadnote.feature_notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.beslimir.myreadnote.feature_notes.data.local.entities.BookEntity
import com.beslimir.myreadnote.feature_notes.data.local.entities.NoteEntity

@Database(
    entities = [BookEntity::class, NoteEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MainDatabase: RoomDatabase() {

    abstract val dao: ReadNoteDao

}