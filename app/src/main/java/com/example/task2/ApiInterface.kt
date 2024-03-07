package com.example.task2

import com.example.task2.Data.dataClassItem
import com.example.task2.Data.dataModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("/posts")
    fun postData(@Body data : dataModel) : Call<Void>
    @GET("/posts")
    fun showData() : Call<List<dataClassItem>>
}