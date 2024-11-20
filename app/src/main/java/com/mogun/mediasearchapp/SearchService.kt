package com.mogun.mediasearchapp

import com.mogun.mediasearchapp.model.ImageListResponse
import com.mogun.mediasearchapp.model.VideoListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("image")
    fun searchImage(@Query("query") query: String): Observable<ImageListResponse>

    @GET("vclip")
    fun searchVideo(@Query("query") query: String): Observable<VideoListResponse>

}