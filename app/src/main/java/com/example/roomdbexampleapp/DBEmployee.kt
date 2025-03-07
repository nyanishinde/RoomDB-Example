package com.example.roomdbexampleapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DCEmployee::class], version = 1)
abstract class DBEmployee : RoomDatabase(){
    abstract fun employeeDao() : DAOEmployee
    companion object {
        @Volatile
        private var INSTANCE: DBEmployee? = null

        fun getDatabase(context: Context): DBEmployee {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBEmployee::class.java,
                    "employee_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}