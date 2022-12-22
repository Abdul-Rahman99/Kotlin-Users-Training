package com.example.myapplicationkotlin.model.local

import androidx.room.*
import com.example.myapplicationkotlin.model.entity.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate (user: User)

    @Delete
    suspend fun deleteUser (user: User)

    @Query("select * from user_table")
    suspend fun getUsers() : List<User>
}