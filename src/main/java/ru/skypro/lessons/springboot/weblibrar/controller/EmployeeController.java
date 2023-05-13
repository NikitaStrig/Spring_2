package ru.skypro.lessons.springboot.weblibrar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/get/{id}")
    public String getId(@PathVariable int id) {
        String idf = "";
        for (int i = 0; i < showCounter().size() ; i++) {
            if (showCounter().get(i).getId() == id){
                idf = showCounter().get(i).getName() + " " + showCounter().get(i).getSalary();
            }
        }
        return idf;
    }
    @GetMapping("/salaryHigherThan")
    public String getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer salary) {

        String getEmp = " ";
        for (int i = 0; i < showCounter().size(); i++) {
            if (showCounter().get(i).getSalary() > salary) {
                 getEmp = getEmp + "\n" + showCounter().get(i).getName();
            }
        }
        return getEmp;
    }
    @DeleteMapping("/delete/{id}")
    public void delId(@PathVariable("id") int id) {
        employeeService.deleteId(id);

    }
    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
    }
    @PutMapping("/{id}")
    public void updEmployee(@PathVariable int id, @RequestBody Employee employee) {
        for (int i = 0; i < showCounter().size() ; i++) {
            if (showCounter().get(i).getId() == id) {
                showCounter().get(i).setName("Abba");
            }

            }
    }

}
