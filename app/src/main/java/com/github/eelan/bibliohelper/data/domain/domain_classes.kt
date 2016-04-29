package com.github.eelan.bibliohelper.data.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*


/**
 * Created by Jansens on 16/03/2016.
 */

data class BookList(val booksList: List<Book>) : Parcelable {
    operator fun get(position: Int) = booksList[position]
    val size = booksList.size

    constructor(source: Parcel) : this({ val l = ArrayList<Book>(); source.readList(l, Book::class.java.classLoader); l }.invoke())

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeList(booksList)
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<BookList> = object : Parcelable.Creator<BookList> {
            override fun createFromParcel(source: Parcel): BookList = BookList(source)

            override fun newArray(size: Int): Array<BookList?> = arrayOfNulls(size)
        }
    }
}

data class Book(val idBook: String, val title: String, val author: String, val cover: String, val description: String) : Parcelable {
    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readString(), source.readString())

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(idBook);
        dest?.writeString(title);
        dest?.writeString(author);
        dest?.writeString(cover);
        dest?.writeString(description);
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<Book> = object : Parcelable.Creator<Book> {
            override fun createFromParcel(source: Parcel): Book = Book(source)

            override fun newArray(size: Int): Array<Book?> = arrayOfNulls(size)
        }
    }
}