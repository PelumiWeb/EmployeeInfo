package com.example.employeeinfoapp.data.mapper

import com.example.employeeinfoapp.data.local.entity.EmployeeEntity
import com.example.employeeinfoapp.domain.model.Employee

fun EmployeeEntity.toDomainModel(): Employee {
    return Employee(
        id= this.id,
        name= this.name,
        designation= this.designation,
        department= this.department
    )
}


fun Employee.toEntity(): EmployeeEntity {
    return EmployeeEntity(
        id= this.id,
        name= this.name,
        designation= this.designation,
        department= this.department
    )
}

fun List<EmployeeEntity>.toDomainModels(): List<Employee> {
    return this.map { it.toDomainModel() }
}


fun List<Employee>.toEntities(): List<EmployeeEntity> {
    return this.map { it.toEntity() }
}