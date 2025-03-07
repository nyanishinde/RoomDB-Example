package com.example.roomdbexampleapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewAllEmployee : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var employeeList : List<DCEmployee>
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
        val adapter = AdapterEmployee(employeeList)
        empRecyclerView.adapter = adapter
    }
}