package com.mogun.mediasearchapp.repository

import com.mogun.mediasearchapp.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {

    fun search(query: String): Observable<List<ListItem>>
}