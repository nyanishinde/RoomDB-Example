package com.example.roomdbexampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterEmployee(private var employees : List<DCEmployee>):RecyclerView.Adapter<AdapterEmployee.EmployeeViewHolder>() {
    inner class EmployeeViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val employeeId : TextView = itemView.findViewById(R.id.empId)
        val employeeName : TextView = itemView.findViewById(R.id.empName)
        val employeeSalary : TextView = itemView.findViewById(R.id.empSalary)
        val employeeDeptId : TextView = itemView.findViewById(R.id.empDeptId)
        val employeeEmail : TextView = itemView.findViewById(R.id.empEmail)
        val employeeAddress : TextView = itemView.findViewById(R.id.empAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int =employees.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val emp = employees[position]
        holder.employeeId.text = emp.empId.toString()
        holder.employeeName.text = emp.empName
        holder.employeeSalary.text = emp.empSalary.toString()
        holder.employeeDeptId.text = emp.empDeptNo.toString()
        holder.employeeEmail.text = emp.empEmail
        holder.employeeAddress.text = emp.empAddress
    }

    fun updateList(newList : List<DCEmployee>){
        employees = newList
        notifyDataSetChanged()
    }

}