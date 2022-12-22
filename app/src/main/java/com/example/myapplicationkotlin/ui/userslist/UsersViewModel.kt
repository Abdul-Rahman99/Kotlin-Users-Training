package com.example.myapplicationkotlin.ui.userslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplicationkotlin.model.entity.User
import com.example.myapplicationkotlin.model.local.LocalRepositoryImp
import com.example.myapplicationkotlin.model.local.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application) : AndroidViewModel(application) {

    private var localRepositoryImp: LocalRepositoryImp


    // default to be public, when u get the user live data and done editing store it in live data

    init {
        val db = UserDatabase.getInstance(application)
        localRepositoryImp = LocalRepositoryImp(db)
    }

    // live data
    private var usersMutableLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> get() = usersMutableLiveData

    fun getUsers() =
        viewModelScope.launch { // to avoid the error cause it is suspend fun: Add (= viewModelScope.launch)
            usersMutableLiveData.postValue(localRepositoryImp.getUsers())
        }

    fun addUser(user: User) {
        viewModelScope.launch {
            localRepositoryImp.insertOrUpdate(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch{
            localRepositoryImp.deleteUser(user)
        }
    }

}