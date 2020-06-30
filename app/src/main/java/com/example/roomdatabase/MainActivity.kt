package com.example.roomdatabase

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.database.BookDatabase
import com.example.roomdatabase.model.Book

class MainActivity : AppCompatActivity() {

    private lateinit var database: BookDatabase

    private lateinit var tvData: TextView
    private lateinit var etBookName: EditText

    private lateinit var btnLoad: Button
    private lateinit var btnClear: Button
    private lateinit var btnInsert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = BookDatabase.getInstance(applicationContext)

        tvData = findViewById(R.id.tv_database_data)
        etBookName = findViewById(R.id.et_bookname)

        btnLoad = findViewById(R.id.btn_load)
        btnClear = findViewById(R.id.btn_clear)
        btnInsert = findViewById(R.id.btn_add)

        btnLoad.setOnClickListener(View.OnClickListener {
            load()
        })

        btnInsert.setOnClickListener(View.OnClickListener {
            insert(Book((Math.random() * 1000).toInt(), etBookName.text.toString()))
        })

        btnClear.setOnClickListener(View.OnClickListener {
            clearAll()
        })

    }


    fun insert(book: Book) {
        database.bookDao().insert(book)
        load()
    }


    fun clearAll() {
        database.bookDao().clearDatabase()
        load()
    }

    fun load() {
        val books = database.bookDao().loadAllBook()
        var str_book = ""
        for (book in books) {
            str_book += book.bookName + " "
        }
        updateUi(str_book)
    }

    fun updateUi(book: String) {
        tvData.text = book
    }


}