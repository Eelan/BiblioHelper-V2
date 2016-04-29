package com.github.eelan.bibliohelper.ui

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.eelan.bibliohelper.R
import com.github.eelan.bibliohelper.data.domain.Book
import com.github.eelan.bibliohelper.ext.load
import kotlinx.android.synthetic.main.book_info.*

/**
 * Created by Jansens on 14/04/2016.
 */

class BookDetailsFragment : Fragment() {
    lateinit var book : Book
        private set

    companion object{
        const val BOOK = ""
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null && arguments.containsKey(BOOK)) book = arguments.getParcelable(BOOK)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.book_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(book) {
            tv_book_title.text = title.toString()
            tv_book_description.text = description.toString()
            img_book_cover.load(cover)
        }

    }
}