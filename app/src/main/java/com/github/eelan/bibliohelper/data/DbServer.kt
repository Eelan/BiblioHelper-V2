package com.github.eelan.bibliohelper.data

import com.github.eelan.bibliohelper.data.db.DbLibrary
import com.github.eelan.bibliohelper.data.domain.BookList
import com.github.eelan.bibliohelper.data.json.ISBN
import com.github.eelan.bibliohelper.data.mapper.DbMapper
import com.orm.query.Condition
import com.orm.query.Select

// PARTIE JONATHAN

class DbServer : LibrarySource {
    override fun getLibrary(title: String, author: String, description: String, isbn: String): BookList? {
        val list = Select.from(DbLibrary::class.java)
                .where(Condition("title").like(title))
                .list()
        if (list.size == 0) return null
        else return DbMapper.convertToDomain(list)
    }

    fun save(bookList: BookList) {
        DbMapper.convertFromDomain(bookList).forEach { it.save() }
    }
}

// PARTIE JONATHAN