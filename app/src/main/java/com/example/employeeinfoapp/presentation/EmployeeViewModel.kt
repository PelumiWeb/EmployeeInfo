package com.example.employeeinfoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeeinfoapp.domain.usecase.GetAllEmployeeUseCase
import com.example.employeeinfoapp.domain.usecase.insertEmployee
import com.example.employeeinfoapp.domain.usecase.insertEmployeeUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val insertEmployeeUsecase: insertEmployeeUsecase,
    private val inserAllEmployeeUseCase: GetAllEmployeeUseCase

): ViewModel() {

   private val  _uiState = MutableStateFlow<EmployeeUiState>(
       EmployeeUiState.Loading
   )
    val uiState: StateFlow<EmployeeUiState> = _uiState.asStateFlow()

    init {
        loadEmployee()
    }

    private fun loadEmployee() {
        viewModelScope.launch {
            getAllEmployeeUseCase()
                .catch {
                    _uiState.value = EmployeeUiState.Error(
                        message = it.message ?: "Uknown error message"
                    )
                }
                .collect { employees ->
                    EmployeeUiState.Success(
                        employees = employees
                    )
                }
        }
    }

     fun insertSampleEmployees() {
        viewModelScope.launch {
            try {
                val currenState = _uiState.value
                if (currenState is EmployeeUiState.Success) {
                    _uiState.value = currenState.copy(isLoading = true)
                }
                inserAllEmployeeUseCase()
            } catch (e: Exception) {
                _uiState.value = EmployeeUiState.Error(
                    message = "Failed to insert employees ${e.message}"
                )
            }
        }
    }

}