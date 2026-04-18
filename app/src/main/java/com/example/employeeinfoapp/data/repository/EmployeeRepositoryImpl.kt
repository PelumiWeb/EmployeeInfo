package com.example.employeeinfoapp.data.repository

import com.example.employeeinfoapp.data.local.dao.EmployeeDao
import com.example.employeeinfoapp.data.mapper.toDomainModels
import com.example.employeeinfoapp.data.mapper.toEntities
import com.example.employeeinfoapp.data.mapper.toEntity
import com.example.employeeinfoapp.domain.model.Employee
import com.example.employeeinfoapp.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl(private val employeeDao: EmployeeDao): EmployeeRepository  {

    override fun getAllRepository(): Flow<List<Employee>> {
        return employeeDao.getAllEmployees().map {
            entries-> entries.toDomainModels()
        }
    }

    override suspend fun insertAllEmployee(employees: List<Employee>) {
        employeeDao.insertAllEmployee(employees.toEntities())
    }

    override suspend fun insertEmployee(employee: Employee) {
        employeeDao.insertEmployee(employee.toEntity())
    }
}