package com.lijo.triviaapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lijo.triviaapp.data.db.entities.User

@Database(
    entities = [User::class],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        // build database
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "MyDatabase" // database name
                        ).fallbackToDestructiveMigration().build() // fall back to db upgrades to avoid exception
                    }
                }
            }
            return INSTANCE  // returns created instance of the db
        }
    }
}