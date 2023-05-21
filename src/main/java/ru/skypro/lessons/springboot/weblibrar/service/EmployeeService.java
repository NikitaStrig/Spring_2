package ru.skypro.lessons.springboot.weblibrar.service;

import ru.skypro.lessons.springboot.weblibrar.controller.Employee;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    void addEmployee(Employee employee);
    List<EmployeeDTO> findWithHighestSalary(String name);
}
