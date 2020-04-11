package com.lijo.triviaapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lijo.triviaapp.data.db.entities.User

@Dao
interface UserDao {

    // insert new data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    // get all user rows
    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getUser() : LiveData<List<User>>

}