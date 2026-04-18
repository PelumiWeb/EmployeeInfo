package com.example.employeeinfoapp.domain.usecase

import com.example.employeeinfoapp.domain.model.Employee
import com.example.employeeinfoapp.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow

class GetAllEmployeeUseCase(private val repository: EmployeeRepository) {

    operator fun invoke(): Flow<List<Employee>> {
        return  repository.getAllRepository()
    }
}