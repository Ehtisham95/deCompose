package com.example.demo_app.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_app.model.EmployeeData
import com.example.demo_app.repository.EmployeeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: EmployeeRepo
) : ViewModel() {

    data class HomeState(
        val list: List<EmployeeData> = emptyList(),
        val generalError: String? = null
    )

    var state = mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            getEmployees()
        }
    }

    private suspend fun getEmployees() {
        repo.getAllEmployees()
            .onSuccess {
                state.value = state.value.copy(list = it.employeeData, generalError = null)
            }
            .onFailure {
                state.value = state.value.copy(generalError = "Something went wrong!")
            }
    }

}