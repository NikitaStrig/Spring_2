package ru.skypro.lessons.springboot.weblibrar.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> resolt = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(resolt::add);
         return resolt.stream()
                 .map(EmployeeDTO::fromEmployee)
                 .toList();
    }
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findWithHighestSalary(String name) {
       return employeeRepository.findWithHighestSalary(name);
    }

}





