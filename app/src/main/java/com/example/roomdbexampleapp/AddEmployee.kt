package com.example.roomdbexampleapp

import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddEmployee : AppCompatActivity() {

    private lateinit var empName: TextInputEditText
    private lateinit var empDeptId: TextInputEditText
    private lateinit var empSalary: TextInputEditText
    private lateinit var empEmail: TextInputEditText
    private lateinit var empAddress: TextInputEditText
    private lateinit var addEmpBtn : MaterialButton
    private lateinit var database: DBEmployee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        empName = findViewById(R.id.edtEmployeeName)
        empDeptId = findViewById(R.id.edtEmpDeptNo)
        empSalary = findViewById(R.id.edtEmpSalary)
        empEmail = findViewById(R.id.edtEmpEmail)
        empAddress = findViewById(R.id.edtEmpAddress)
        addEmpBtn=findViewById(R.id.AddEmployee)

        database = DBEmployee.getDatabase(this)

        addEmpBtn.setOnClickListener {
            val name = empName.text.toString()
            val deptId = empDeptId.text.toString().toInt()
            val salary = empSalary.text.toString().toDouble()
            val email = empEmail.text.toString()
            val address = addEmpBtn.text.toString()
            val employee = DCEmployee(0,name,deptId,salary,email,address)

            GlobalScope.launch {
                database.employeeDao().upsertEmployee(employee)
                runOnUiThread{
                    Toast.makeText(this@AddEmployee, "Employee added", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

        }

    }
}