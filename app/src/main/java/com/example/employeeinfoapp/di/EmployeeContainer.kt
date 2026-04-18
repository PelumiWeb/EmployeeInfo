package com.example.employeeinfoapp.di

import android.content.Context
import com.example.employeeinfoapp.data.local.database.EmployeeDatabase
import com.example.employeeinfoapp.data.repository.EmployeeRepositoryImpl
import com.example.employeeinfoapp.domain.repository.EmployeeRepository
import com.example.employeeinfoapp.domain.usecase.GetAllEmployeeUseCase
import com.example.employeeinfoapp.domain.usecase.insertEmployee
import com.example.employeeinfoapp.domain.usecase.insertEmployeeUsecase

class EmployeeContainer(context: Context) {
    private val database: EmployeeDatabase = EmployeeDatabase.getDatabase(context)

    private val employeeDao = database.employeeDao()

    val repository: EmployeeRepository = EmployeeRepositoryImpl(employeeDao)

    val getAllEmployeeUsecase = GetAllEmployeeUseCase(repository);
    val insertEmployeeUsecase = insertEmployeeUsecase(repository)
    val insertAllEmployeeUsease = insertEmployee(repository)
}