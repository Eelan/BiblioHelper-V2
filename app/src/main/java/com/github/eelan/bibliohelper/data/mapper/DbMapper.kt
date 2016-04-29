package com.github.eelan.bibliohelper.data.mapper

import com.github.eelan.bibliohelper.data.db.DbLibrary
import com.github.eelan.bibliohelper.data.domain.Book
import com.github.eelan.bibliohelper.data.domain.BookList

// PARTIE JONATHAN

object DbMapper {
    fun convertToDomain(books: List<DbLibrary>) = with(books) {
        BookList(convertListToDomain(this))
    }

    private fun convertListToDomain(list: List<DbLibrary>) = list.map {
        convertItemListToDomain(it)
    }

    private fun convertItemListToDomain(dbLibrary: DbLibrary) = with(dbLibrary) {
        Book(id, title, author, cover, description)
    }

    fun convertFromDomain(libraryList: BookList) = with(libraryList) {
        convertListFromDomain(booksList)
    }

    private fun convertListFromDomain(list: List<Book>) = list.map {
        convertItemListFromDomain(it)
    }

    private fun convertItemListFromDomain(library: Book) = with(library) {
        DbLibrary(idBook, title, author, cover, description)
    }
}

// PARTIE JONATHAN