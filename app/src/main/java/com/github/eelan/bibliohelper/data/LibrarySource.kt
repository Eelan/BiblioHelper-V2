package com.github.eelan.bibliohelper.data

import com.github.eelan.bibliohelper.data.domain.BookList

// PARTIE JONATHAN

interface LibrarySource {
    fun getLibrary(title: String, author: String, description: String, isbn: String): BookList?

}

// PARTIE JONATHAN