package com.example.demo_app.repository

import com.example.demo_app.model.EmployeesResponse
import com.example.demo_app.network.NetworkInterface
import com.example.demo_app.network.handleRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class EmployeeRepo @Inject constructor(
    private val networkInterface: NetworkInterface
) {

    suspend fun getAllEmployees(): Result<EmployeesResponse> {
        return handleRequest { networkInterface.listRepos() }
    }
}
