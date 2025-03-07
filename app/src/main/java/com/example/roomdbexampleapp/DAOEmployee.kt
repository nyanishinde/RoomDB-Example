package com.example.roomdbexampleapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface DAOEmployee {

    @Upsert
    suspend fun upsertEmployee(employee:DCEmployee)

    @Delete
    suspend fun deleteEmployee(employee: DCEmployee)

    @Query("SELECT * FROM employee")
    fun getAllEmployees():LiveData<List<DCEmployee>>

    @Query("SELECT * FROM employee ORDER BY empDeptNo")
    fun getAllEmployeeByDeptNo():LiveData<List<DCEmployee>>

    @Query("SELECT * FROM employee ORDER BY empName")
    fun getAllEmployeeByName():LiveData<List<DCEmployee>>
}