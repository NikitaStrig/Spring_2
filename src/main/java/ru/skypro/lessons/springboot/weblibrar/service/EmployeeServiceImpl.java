package ru.skypro.lessons.springboot.weblibrar.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;
import ru.skypro.lessons.springboot.weblibrar.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibrar.repository.EmployeeRepositoryImpl;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public String getMaxSolary() {
        return employeeRepository.getMaxSolary();
    }
    public String getMinSolary() {
        return employeeRepository.getMinSolary();
    }
    public int getSumAllSolary() {
        return employeeRepository.getSumAllSolary();
    }
    public String getHighSolary() {return employeeRepository.getHighSolary();}

    @Override
    public void deleteId(int id) {
       employeeRepository.deleteId(id);
    }

    @Override
    public String getSearchId(int id) {
        return employeeRepository.getSearchId(id);
    }

    @Override
    public String getsalaryHigherThan(int salary) {
        return employeeRepository.getsalaryHigherThan(salary);
    }


}



