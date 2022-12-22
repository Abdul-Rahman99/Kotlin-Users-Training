package com.example.myapplicationkotlin.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplicationkotlin.model.entity.User

private const val DATABASE_NAME = "user_database"

@Database(entities = [User :: class] , version = 1 , exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDAO() : UserDAO

    // any one want to call same class many times
    companion object{

        @Volatile
        // to be watched to all threads
        private var instance : UserDatabase ?= null

        // check if database is existed ? : if not lock the code and create data base
        fun getInstance(context : Context) : UserDatabase{
            return instance?: synchronized(Any()){
                instance?: buildDatabase(context).also{ instance = it}
            }
        }
        // if database is not created or it's the first time to use
        // this function creates the database
        private fun buildDatabase(context: Context): UserDatabase {
            return Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,
            DATABASE_NAME).build()
        }
    }



}