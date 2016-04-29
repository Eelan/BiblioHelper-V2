package com.github.eelan.bibliohelper.data

import com.github.eelan.bibliohelper.data.domain.BookList
import com.github.eelan.bibliohelper.data.json.BookResult
import com.github.eelan.bibliohelper.data.mapper.JsonMapper
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Jansens on 16/03/2016.
 */
class JsonServer : LibrarySource {

    val APP_ID = "AIzaSyAVsOY4c1O1xJygxf6XM3pRihrjH70YfKw"
    val SEARCH_QUERY = "isbn:9782070515790"
    /*
    "isbn:9782070515790"
    "isbn:9782207303405"
    "isbn:2226197591"
    https://www.googleapis.com/books/v1/volumes?q=isbn:9782207303405*/
    val SEARCH_URL = "https://www.googleapis.com/books/v1/volumes?q=isbn:%s&key=$APP_ID"

    override fun getLibrary(title: String, author: String, description: String, isbn: String): BookList {
        val jsonStr = URL(SEARCH_URL.format(isbn)).readText()
        val result = Gson().fromJson(jsonStr, BookResult::class.java)
        val book = JsonMapper.convertToDomain(result)
        //DbServer().save(book)
        return book
    }

}