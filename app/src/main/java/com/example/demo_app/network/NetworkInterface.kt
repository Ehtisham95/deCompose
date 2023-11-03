package com.example.demo_app.network

import com.example.demo_app.model.EmployeesResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkInterface {

    @GET("employees")
    suspend fun listRepos(): EmployeesResponse

}