package com.lijo.triviaapp.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.lijo.triviaapp.data.db.entities.User
import com.lijo.triviaapp.data.repositories.UserRepository

class AuthViewModel (application: Application) : AndroidViewModel(application) {

    // initialize user repository in viewmodel
    private var repository:UserRepository = UserRepository(application)

    fun getUsers() = repository.getUsers()

    fun upsert(user: User) { repository.upsert(user)}

}