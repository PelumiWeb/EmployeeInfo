package com.example.employeeinfoapp.domain.usecase

import com.example.employeeinfoapp.domain.model.Employee
import com.example.employeeinfoapp.domain.repository.EmployeeRepository

class insertEmployee(private val repository: EmployeeRepository) {

    suspend operator fun invoke(employee: Employee) {
        repository.insertEmployee(employee)
    }
}