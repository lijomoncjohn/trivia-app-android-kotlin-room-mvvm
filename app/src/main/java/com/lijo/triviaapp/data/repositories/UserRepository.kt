package com.lijo.triviaapp.data.repositories

import android.app.Application
import com.lijo.triviaapp.data.db.AppDatabase
import com.lijo.triviaapp.data.db.UserDao
import com.lijo.triviaapp.data.db.entities.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


class UserRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var userDao: UserDao?

    // initialize the db
    init {
        val db = AppDatabase.getDatabase(application)
        userDao = db?.getUserDao()
    }

    // get users function
    fun getUsers() = userDao?.getUser()

    // insert function
    fun upsert(user: User) {
        launch  { setUser(user) }
    }

    // insert user co routine
    private suspend fun setUser(user: User){
        withContext(Dispatchers.IO){
            userDao?.upsert(user)
        }
    }

}