package com.example.myapplicationkotlin.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "user_table")

data class User(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
   // @ColumnInfo(name = "user_name")
    var name:String,
    var message: String,
    var imageId:Int)

