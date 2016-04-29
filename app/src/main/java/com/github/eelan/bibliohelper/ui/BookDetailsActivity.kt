package com.github.eelan.bibliohelper.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.eelan.bibliohelper.R
import com.github.eelan.bibliohelper.data.domain.Book

/**
 * Created by Jansens on 14/04/2016.
 */
class BookDetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_info)

        val book = intent.getParcelableExtra<Book>(BookDetailsFragment.BOOK)
        if (savedInstanceState == null ) fragmentManager
                .beginTransaction()
                .replace(R.id.container, BookDetailsFragment().apply {
                    arguments = Bundle().apply { putParcelable(BookDetailsFragment.BOOK, book) }
                })
                .commit()
    }
}