package com.example.roomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "book_name") val bookName: String?
)