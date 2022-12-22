package com.example.myapplicationkotlin.model.local

import com.example.myapplicationkotlin.model.entity.User

interface LocalRepository {

    suspend fun getUsers() : List<User>

    suspend fun deleteUser (user: User)

    suspend fun insertOrUpdate (user: User)
}