package com.example.myapplicationkotlin.model.remote

import com.example.myapplicationkotlin.model.entity.User
import retrofit2.Response
import retrofit2.http.GET

interface ServiceAPI {

    @GET ("")
    suspend fun getAPIUsers () : Response<List<User>>


}