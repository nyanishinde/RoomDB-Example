package com.example.roomdbexampleapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DCEmployee::class],
    version = 1
)
abstract class DBEmployee : RoomDatabase(){
    abstract fun employeeDao() : DAOEmployee
}