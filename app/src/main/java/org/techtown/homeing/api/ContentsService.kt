package org.techtown.homeing.api

import org.techtown.homeing.data.GalData
import retrofit2.Call
import retrofit2.http.GET

interface ContentsService {
    @GET("/challenge/contents")
    fun getContents(): Call<GalData>
}