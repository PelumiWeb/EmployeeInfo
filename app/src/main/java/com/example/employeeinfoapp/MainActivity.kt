package com.example.employeeinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.employeeinfoapp.di.EmployeeContainer
import com.example.employeeinfoapp.domain.usecase.insertEmployee
import com.example.employeeinfoapp.presentation.EmployeeViewModel
import com.example.employeeinfoapp.presentation.EmployeeViewModelFactory
import com.example.employeeinfoapp.ui.theme.EmployeeInfoAppTheme
import com.example.employeeinfoapp.ui.theme.EmployeeScreen

class MainActivity : ComponentActivity() {
    private lateinit var employeeContainer: EmployeeContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        employeeContainer = EmployeeContainer(applicationContext)

        enableEdgeToEdge()
        setContent {
            EmployeeInfoAppTheme {
                val viewModel: Lazy<ERROR> = viewModels {
                    var factory = EmployeeViewModelFactory(
                        getAllEmployeeUseCase = employeeContainer.getAllEmployeeUsecase,
                        insertEmployeeUsecase = employeeContainer.insertEmployeeUsecase,
                        inserAllEmployeeUseCase = employeeContainer.insertEmployeeUsecase
                    )
                }

                EmployeeScreen(vieModel = viewModel)

            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmployeeInfoAppTheme {
        Greeting("Android")
    }
}