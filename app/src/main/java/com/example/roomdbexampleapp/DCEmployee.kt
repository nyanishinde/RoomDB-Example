package com.example.roomdbexampleapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class DCEmployee(
    @PrimaryKey(autoGenerate = true)
    val empId: Int,
    val empName: String,
    val empDeptNo: Int,
    val empSalary: Double,
    val empEmail: String,
    val empAddress: String
)
