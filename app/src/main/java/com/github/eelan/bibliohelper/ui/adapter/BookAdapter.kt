package com.github.eelan.bibliohelper.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.github.eelan.bibliohelper.R
import com.github.eelan.bibliohelper.data.domain.Book
import com.github.eelan.bibliohelper.data.domain.BookList
import com.github.eelan.bibliohelper.ext.inflate
import com.github.eelan.bibliohelper.ext.load
import kotlinx.android.synthetic.main.item_book_list.view.*

/**
 * Created by Jansens on 15/03/2016.
 */

class BookAdapter(val items: BookList, val click: (Book) -> Unit) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_book_list, false), click)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindForecast(items[position])

    inner class ViewHolder(view: View, val click: (Book) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindForecast(book: Book) = with(book) {
            with(itemView) {
                book_icon.load(cover)
                book_author.text = author
                book_title.text = title
                setOnClickListener { click(book) }
            }
        }
    }
}