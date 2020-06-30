package com.example.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.model.Book

@Dao
interface BookDao {

    @Insert
    fun insert(book: Book)


    @Query("DELETE FROM book")
    fun clearDatabase()

    @Query("SELECT * FROM book")
    fun loadAllBook(): List<Book>


}