package com.example.demo_app.model

import com.google.gson.annotations.SerializedName

data class EmployeesResponse(
    @SerializedName("data")
    val employeeData: List<EmployeeData>,
    val status: String
)

data class EmployeeData(
    val employee_age: String,
    val employee_name: String,
    val employee_salary: String,
    val id: String,
    val profile_image: String
)