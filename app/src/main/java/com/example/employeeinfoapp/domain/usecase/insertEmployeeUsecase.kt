package com.example.employeeinfoapp.domain.usecase

import com.example.employeeinfoapp.domain.model.Employee
import com.example.employeeinfoapp.domain.repository.EmployeeRepository

class insertEmployeeUsecase(private val repository: EmployeeRepository) {

    suspend operator fun invoke() {
        val sampleEmployees = listOf(
            Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 ),
        Employee(name = "John Doe", designation = "Softward Engineer", department = "Engineer", id = 1 )

        )
        repository.insertAllEmployee(sampleEmployees)
    }
}