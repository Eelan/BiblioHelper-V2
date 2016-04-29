package com.github.eelan.bibliohelper.data.json

import java.net.URL

/**
 * Created by Jansens on 11/03/2016.
 */

data class BookResult(val kind: String, val totalItems: Int, val items: List<Book>)

data class Book(val kind: String,
                val id: String,
                val etag: String,
                val selfLink: URL,
                val volumeInfo: VolumeInfo,
                val saleInfo: SaleInfo,
                val accessInfo: AccessInfo,
                val searchInfo: SearchInfo)

data class VolumeInfo(val title: String,
                      val subtitle: String,
                      val authors: List<String>,
                      val publisher: String,
                      val publishedDate: String,
                      val description: String,
                      val industryIdentifiers: List<ISBN>,
                      val pageCount: Int,
                      val dimensions: Dimensions,
                      val readingModes: ReadingMode, // ?
                      val printType: String,
                      val mainCategory: String,
                      val categories: List<String>,
                      val averageRating: Double,
                      val ratingsCount: Int,
                      val maturityRating: String, // ?
                      val allowAnonLogging: Boolean, // ?
                      val contentVersion: String,
                      val imageLinks: ImagesLink,
                      val language: String,
                      val previewLink: URL,
                      val infoLink: URL,
                      val canonicalVolumeLink: URL)


data class ISBN(val type: String, val identifier: String)
data class Dimensions(val height: String, val width: String, val thickness: String)
data class ReadingMode(val text: Boolean, val image: Boolean)
data class ImagesLink(val smallThumbnail: String?, val thumbnail: String?)
data class SaleInfo(val country: String,
                    val saleability: String,
                    val onSaleDate: String,
                    val isEbook: Boolean,
                    val listPrice: Price,
                    val retailPrice: Price,
                    val buyLink: URL)

data class Price(val amount : Double, val currencyCode: String)
data class AccessInfo(val country: String,
                      val viewability: String,
                      val embeddable: Boolean,
                      val publicDomain: Boolean,
                      val textToSpeechPermission: String,
                      val epub: EBook,
                      val pdf: EBook,
                      val webReaderLink: URL,
                      val accessViewStatus: String,
                      val quoteSharingAllowed: Boolean, // ?
                      val downloadAccess: DownloadAccess )
data class DownloadAccess(val kind: String,
                          val volumeId: String,
                          val restricted: Boolean,
                          val deviceAllowed: Boolean,
                          val justAcquired: Boolean,
                          val maxDownloadDevices: Int,
                          val downloadsAcquired: Int,
                          val nonce: String,
                          val source: String,
                          val reasonCode: String,
                          val message: String,
                          val signature: String)

data class EBook(val isAvailable: Boolean, val downloadLink: String, val acsTokenLink: String)
data class SearchInfo(val textSnippet: String)