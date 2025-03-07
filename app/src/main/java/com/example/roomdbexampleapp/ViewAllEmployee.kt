package com.example.roomdbexampleapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class ViewAllEmployee : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var adapter : AdapterEmployee
    private lateinit var db : DBEmployee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_all_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        empRecyclerView = findViewById(R.id.recyclerView)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AdapterEmployee(emptyList())
        empRecyclerView.adapter = adapter

        db = DBEmployee.getDatabase(this)

        fetchEmployees()
    }
    private fun fetchEmployees(){
        db.employeeDao().getAllEmployeeByName().observe(this, Observer { employeeList->
            employeeList?.let{
                adapter.updateList(it)
            }
        })
    }
}