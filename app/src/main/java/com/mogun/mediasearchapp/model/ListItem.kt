package com.mogun.mediasearchapp.model

import java.util.Date

interface ListItem {
    val thumbnailUrl: String
    val dateTime: Date
    val isFavorite: Boolean
}
