package com.mogun.mediasearchapp.list

import com.mogun.mediasearchapp.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem)

}