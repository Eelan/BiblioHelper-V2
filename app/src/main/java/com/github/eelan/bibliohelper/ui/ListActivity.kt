package com.github.eelan.bibliohelper.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.github.eelan.bibliohelper.R
import com.github.eelan.bibliohelper.data.JsonServer
import com.github.eelan.bibliohelper.data.LibraryProvider
import com.github.eelan.bibliohelper.ui.adapter.BookAdapter
import kotlinx.android.synthetic.main.book_list.*
import org.jetbrains.anko.async
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

/**
 * Created by Jansens on 16/03/2016.
 */
class ListActivity : AppCompatActivity() {
    var isbn = ""
    var title = ""
    var author = ""
    var description = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list)
        isbn = intent.getStringExtra(MainActivity.ISBN)

    }

    override fun onResume() {
        super.onResume()
        async() {
            val items = JsonServer().getLibrary(title, author, description, isbn)

            uiThread {
                vBookList.adapter = BookAdapter(items) { it ->
                    startActivity<BookDetailsActivity>(BookDetailsFragment.BOOK to it)
                }
            }
        }
    }
}
