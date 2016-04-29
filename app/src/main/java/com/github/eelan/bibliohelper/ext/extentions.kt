package com.github.eelan.bibliohelper.ext

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Jansens on 15/03/2016.
 */

fun ImageView.load(url: String) = Picasso.with(this.context).load(url).into(this)

fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false) = LayoutInflater.from(this.context).inflate(layout, this, attachToRoot)