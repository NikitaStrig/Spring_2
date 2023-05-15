package ru.skypro.lessons.springboot.weblibrar.repository;

import ru.skypro.lessons.springboot.weblibrar.controller.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

    String getMaxSolary();

    String getMinSolary();

    int getSumAllSolary();
    String getHighSolary();

    void deleteId(int id);

    String getSearchId(int id);
    String getsalaryHigherThan(int salary);
    String addEmployee (Employee employee);
    String updateEmployee (Employee employee, int id);

}
