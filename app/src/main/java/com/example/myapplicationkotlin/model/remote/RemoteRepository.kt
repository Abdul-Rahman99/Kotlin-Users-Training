package com.example.myapplicationkotlin.model.remote

import com.example.myapplicationkotlin.model.entity.User
import retrofit2.Response

interface RemoteRepository{
    suspend fun getAPIUsers () : Response<List<User>>

}