package com.example.myapplicationkotlin.model.remote

import com.example.myapplicationkotlin.model.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteRepositoryImp(private val api:ServiceAPI) : RemoteRepository {
    override suspend fun getAPIUsers() =
        withContext(Dispatchers.IO){
            api.getAPIUsers()
    }
}