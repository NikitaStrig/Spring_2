package ru.skypro.lessons.springboot.weblibrar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrar.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showCounter() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/salary/max")
    public String max() {
        return employeeService.getMaxSolary();
    }
    @GetMapping("/salary/min")
    public String min() {
        return employeeService.getMinSolary();
    }
    @GetMapping("/salary/sum")
    public int sum() {
        return employeeService.getSumAllSolary();
    }
    @GetMapping("high-salary")
    public String hsalary() {return employeeService.getHighSolary();
    }

}
