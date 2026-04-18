package com.example.employeeinfoapp.domain.repository

import com.example.employeeinfoapp.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    fun getAllRepository(): Flow<List<Employee>>
    suspend fun insertEmployee(employee: Employee)
    suspend fun insertAllEmployee(employees: List<Employee>)

}