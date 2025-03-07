Employee Management App

📌 Overview

The Employee Management App is an Android application built using Kotlin and Room Database. It allows users to add, view, and manage employee records with an intuitive UI based on Material Design. The app follows a 3-Activity structure, ensuring smooth navigation and efficient data management.

📱 Features

Add new employees with details:

Name

Salary

Department ID

Email

Address

View all employees in a RecyclerView.

Uses Room Database for persistent storage.

Auto-generated Employee ID for uniqueness.

Follows MVVM architecture with coroutines for background tasks.

🏗️ Tech Stack

Language: Kotlin

Database: Room Database

UI Components: RecyclerView, Material Design

Threading: Coroutines, lifecycleScope

Architecture: MVVM (ViewModel, Repository, DAO)

⚙️ Steps to Create This Application

1️⃣ Setup Your Android Project

Open Android Studio and create a new Empty Activity project.

Select Kotlin as the language.

Add the required dependencies in build.gradle (Module: app):

Enable Kotlin annotation processing (KAPT) in build.gradle:

2️⃣ Define Room Database Components
Create Employee Entity
Create DAO Interface
Setup Room Database

3️⃣ Implement RecyclerView for Employee List
Create RecyclerView Adapter
Display Data in RecyclerView

🎯 How to Use the App

1️⃣ Open the app and select "Add Employee" to enter employee details.2️⃣ Click "Save", and the employee will be stored in the Room Database.3️⃣ Go back and select "View All Employees" to see the list in a RecyclerView.
