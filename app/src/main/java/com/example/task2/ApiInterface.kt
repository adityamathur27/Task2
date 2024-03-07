package com.example.task2

import com.example.task2.Data.dataClassItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    fun showData() : Call<List<dataClassItem>>
}