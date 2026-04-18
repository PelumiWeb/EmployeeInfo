package com.example.employeeinfoapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.employeeinfoapp.presentation.EmployeeUiState
import com.example.employeeinfoapp.presentation.EmployeeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeScreen(
    viewModel: EmployeeViewModel,
    modifier: Modifier = Modifier
) {
val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Employee Information",
                        style = MaterialTheme.typography.titleLarge)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),

            )

        },
        floatingActionButton = {
            if (uiState is EmployeeUiState.Success) {
                FloatingActionButton(onClick = {viewModel.insertSampleEmployees()}, containerColor = MaterialTheme.colorScheme.primary) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add sample Employees"
                    )
                }
            }
        }

    ) {paddingValues ->
        Box(
            modifier = modifier.fillMaxSize().padding(paddingValues)



        ){
            when (val state = uiState) {
                is EmployeeUiState.Loading -> {
                    LoadingContent()
                }

                is EmployeeUiState.Success -> {
                    if (state.employees.isEmpty()) {
                        EmptyContent()
                    } else {
                        EmployeeListContent(
                            employees = state.employees,
                            isLoading = state.isLoading,
                        )
                    }
                }

                is EmployeeUiState.Error -> {
//                    ErrorContent(message = state.message)
                }
            }
        }
    }
}