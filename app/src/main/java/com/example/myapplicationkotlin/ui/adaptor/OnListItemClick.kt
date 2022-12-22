package com.example.myapplicationkotlin.ui.adaptor

import com.example.myapplicationkotlin.model.entity.User

interface OnListItemClick {
    fun onItemClick (user: User)
}