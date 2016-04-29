package com.github.eelan.bibliohelper.data.mapper

import com.github.eelan.bibliohelper.data.domain.BookList
import com.github.eelan.bibliohelper.data.json.BookResult
import com.github.eelan.bibliohelper.data.domain.Book as DomainBook
import com.github.eelan.bibliohelper.data.json.Book as JsonBook

/**
 * Created by Jansens on 16/03/2016.
 */

object JsonMapper{
    fun convertToDomain(result: BookResult) = with(result) {
        BookList(convertListToDomain(items))
    }

    private fun convertListToDomain(list: List<JsonBook>) = list.map { convertItemToDomain(it) }

    private fun convertItemToDomain(item: JsonBook) = with(item) {
        DomainBook(idBook = id, title = volumeInfo.title, author = volumeInfo.authors[0], cover = volumeInfo.imageLinks.thumbnail ?: "https://books.google.be/books/content?id=q09yQgAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api", description = volumeInfo.description);
    }

}