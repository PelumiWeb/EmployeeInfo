package com.example.employeeinfoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.employeeinfoapp.domain.usecase.GetAllEmployeeUseCase
import com.example.employeeinfoapp.domain.usecase.insertEmployeeUsecase

class EmployeeViewModelFactory(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val insertEmployeeUsecase: insertEmployeeUsecase,
    private val inserAllEmployeeUseCase: GetAllEmployeeUseCase
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)){
            return EmployeeViewModel(
                getAllEmployeeUseCase,
                insertEmployeeUsecase,
                inserAllEmployeeUseCase
            ) as T
        }
       throw IllegalArgumentException("Unknown ViewModel Class")
    }


}