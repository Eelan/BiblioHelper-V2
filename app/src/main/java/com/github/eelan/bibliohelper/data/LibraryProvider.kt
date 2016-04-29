package com.github.eelan.bibliohelper.data

import com.github.eelan.bibliohelper.data.domain.BookList
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.*

// PARTIE JONATHAN

object LibraryProvider : LibrarySource, AnkoLogger {
    val sources = arrayOf(DbServer(), JsonServer())
    override fun getLibrary(title: String, author: String, description: String, isbn: String): BookList {
        for (source in sources) {
            val fore = source.getLibrary(title, author, description, isbn)
            if (fore != null) {
                info("data sent from $source")
                return fore
            }
        }
        throw NoSuchElementException("No element found !")
    }
}

// PARTIE JONATHAN