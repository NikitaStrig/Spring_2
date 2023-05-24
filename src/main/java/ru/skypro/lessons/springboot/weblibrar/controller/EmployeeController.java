package ru.skypro.lessons.springboot.weblibrar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeePosition;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeViewName;
import ru.skypro.lessons.springboot.weblibrar.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;


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
    public List<EmployeeViewName> findWithHighestSalary(){
      return employeeService.findWithHighestSalary();
   }

   @PostMapping
      public void addEmployee(@RequestBody Employee employee) {
         employeeService.addEmployee(employee);

   }
    @GetMapping("/{id}/fullInfo")
    public List<EmployeeFullInfo> findAllEmployeeFullInfo(@PathVariable("id") Integer id) {
        return employeeService.findAllEmployeeFullInfo(id);
}
    @GetMapping("/position")
    public List<EmployeePosition> findAllEmployeePosition(@RequestParam("position") String positionName) {
        if (positionName =="") {
            return employeeService.findAllEmployeeNoPosition();
        }
        else{
            return employeeService.findAllEmployeePosition(positionName);}
    }
}
