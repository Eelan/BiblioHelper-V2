package com.github.eelan.bibliohelper.data.db

import com.orm.SugarRecord
import com.orm.dsl.Unique

// PARTIE JONATHAN

class DbLibrary(
        @Unique var id: String = "",
        var title: String = "",
        var author: String = "",
        var cover: String = "",
        var description: String = "") : SugarRecord()

// PARTIE JONATHAN