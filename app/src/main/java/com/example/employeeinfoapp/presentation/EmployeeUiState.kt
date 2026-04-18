package com.example.employeeinfoapp.presentation

import com.example.employeeinfoapp.domain.model.Employee

interface EmployeeUiState {

    data object Loading: EmployeeUiState
    data class Success (
        val employees: List<Employee>,
        val isLoading: Boolean = false,


    ): EmployeeUiState

    data class Error(val message: String): EmployeeUiState
}