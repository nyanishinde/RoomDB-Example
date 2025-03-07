package com.example.roomdbexampleapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOEmployee {

    @Upsert
    suspend fun upsertEmployee(employee:DCEmployee)

    @Delete
    suspend fun deleteEmployee(employee: DCEmployee)

    @Query("SELECT * FROM employee")
    fun getAllEmployees():LiveData<List<DCEmployee>>

}