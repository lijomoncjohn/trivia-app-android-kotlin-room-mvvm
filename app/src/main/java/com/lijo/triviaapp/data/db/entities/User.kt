package com.lijo.triviaapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER = 0

@Entity
data class User(

    // auto generate primary key
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "answer_one")
    var answer_one: String,

    @ColumnInfo(name = "answer_two")
    var answer_two: String
)