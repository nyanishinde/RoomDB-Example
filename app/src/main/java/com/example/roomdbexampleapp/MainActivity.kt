package com.example.roomdbexampleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnAddEmployee: Button
    private lateinit var btnViewAllEmployee: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAddEmployee = findViewById(R.id.addEmployee)
        btnViewAllEmployee = findViewById(R.id.viewAllEmployee)

        btnAddEmployee.setOnClickListener {
            startActivity(Intent(this,AddEmployee::class.java))
        }
        btnViewAllEmployee.setOnClickListener {
            startActivity(Intent(this,ViewAllEmployee::class.java))
        }

    }
}