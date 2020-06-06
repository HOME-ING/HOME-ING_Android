package org.techtown.homeing.ui.login

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://52.79.90.119:3004")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service:RequestInterface = retrofit.create(RequestInterface::class.java)
}