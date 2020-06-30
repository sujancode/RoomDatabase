package com.example.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.dao.BookDao
import com.example.roomdatabase.model.Book

@Database(entities = arrayOf(Book::class), version = 1, exportSchema = false)
abstract class BookDatabase() : RoomDatabase() {


    companion object {
        private val databaseName = "book"
        private var INSTANCE: BookDatabase? = null
        fun getInstance(context: Context): BookDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, BookDatabase::class.java, databaseName)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }

    abstract fun bookDao(): BookDao


}