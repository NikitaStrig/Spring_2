package ru.skypro.lessons.springboot.weblibrar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

 @GetMapping
    public List<EmployeeDTO> getAllEmp() {
       return employeeService.getAllEmployees();
    }
//    @GetMapping("/salary/max")
//    public String max() {
//        return employeeService.getMaxSolary();
//    }
//    @GetMapping("/salary/min")
//    public String min() {
//        return employeeService.getMinSolary();
//    }
//    @GetMapping("/salary/sum")
//    public int sum() {
//        return employeeService.getSumAllSolary();
//    }
//    @GetMapping("/id")
//    public List<EmployeeDTO> getId(String name, int salary) {
//     return employeeService.ffrr(name, salary);
//    }

   @GetMapping("/salaryHigherThan")
    public List<EmployeeDTO> withHighestSalary(String name){
      return employeeService.findWithHighestSalary(name);
   }
//    @DeleteMapping("/delete/{id}")
//    public void delId(@PathVariable("id") int id) {
//        employeeService.deleteId(id);
//
//    }
   @PostMapping
      public void addEmployee(@RequestBody Employee employee) {
         employeeService.addEmployee(employee);

   }
//    @PutMapping("/{id}")
//    public String updEmployee(@PathVariable int id, @RequestBody Employee employee) {
//        return employeeService.updateEmployee(employee,id);


//}

}
